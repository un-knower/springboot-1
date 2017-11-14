package com.telit.springboot.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.telit.springboot.filter.DataGrid;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.ActivityModel;
import com.telit.springboot.web.model.RecipeModel;
import com.telit.springboot.web.model.RecipeTypeModel;
import com.telit.springboot.web.model.TelitUser;
import com.telit.springboot.web.service.RecipeService;
import com.telit.springboot.web.service.RecipeTypeService;
import com.telit.springboot.web.service.TelitSchoolService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 食谱控制器
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Resource(name = "recipeTypeServiceImpl")
    private RecipeTypeService recipeTypeService;

    @Resource(name = "recipeServiceImpl")
    private RecipeService recipeService;

    @Resource(name = "telitSchoolServiceImpl")
    private TelitSchoolService telitSchoolService;
    /**
     * 初始化打开食谱列表
     * @return
     */
    @RequestMapping("/recipeList")
    public String activityList(){
        return "recipe/recipeList";
    }
    @RequestMapping("/getFrameView")
    public String getFrameView(){
        return "recipe/frame";
    }

    /**
     * 首页获取数据列表
     * @return
     */
    @RequestMapping("/getRecipeList")
    @ResponseBody
    public Object getRecipeList(String indexCode,String indexName,Integer page,Integer rows){
        //indexCode:{time:按时间，name:按食物名称,type:按类型}
        if(StringUtil.isEmpty(indexName)){
            indexName="";
        }
        List<Object[]> objects = recipeService.findByFoodName(indexName);
        List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
        for(Object[] obj:objects){
            mapList.add(ListUtil.objectToMap(obj,"id","tId","schoolId","weekly","foodName","mealType","photo","foodDesc","createDate"));
        }
        return JSONObject.toJSONString(new DataGrid<Map<String,Object>>(mapList.size(),page,(List<Map<String,Object>>)PaginationUtil.pageMap(mapList,page,rows).get("newList")));
    }

    /**
     * 打开食谱新增页面
     * @return
     */
    @RequestMapping("/openAddView")
    public String openAddView(HttpServletRequest request){
        HttpSession session=request.getSession();
        TelitUser telitUser=(TelitUser)session.getAttribute(NameUtil.CURRENT_USER);
        request.setAttribute("schoolName",telitSchoolService.findOne(telitUser.getSchoolId()).getSchoolName());
        request.setAttribute("schoolId",telitUser.getSchoolId());
        return "recipe/recipeAdd";
    }

    /**
     * 食物新增保存
     * @param recipeModel
     * @param recipeTypeModel
     * @return
     */
    @RequestMapping("/recipeAdd")
    @ResponseBody
    public Object recipeAdd(RecipeModel recipeModel, RecipeTypeModel recipeTypeModel,HttpServletRequest request){
        TelitUser telitUser=(TelitUser)request.getSession().getAttribute(NameUtil.CURRENT_USER);
        recipeTypeModel.setCreateDate(new Date());
        if(BeanUtil.isNotEmpty(telitUser)){
            recipeTypeModel.setCreateUser(telitUser.getId().toString());
        }
        recipeTypeModel.setPhoto(StringUtils.strip(JSONObject.parseArray(recipeTypeModel.getPhoto(),String.class).toString(),"[]"));
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.eq("schoolId",recipeModel.getSchoolId()));
        filters.add(Filter.eq("weekly",recipeModel.getWeekly()));
        RecipeModel recipe = recipeService.find(filters);
        if(BeanUtil.isNotEmpty(recipe)){
            if(StringUtil.isNotEmpty(recipe.getId())){
                recipeTypeModel.setRecipeId(recipe.getId());
                recipeTypeService.save(recipeTypeModel);
                return true;
            }
             return false;
        }else{
            try {
                recipeService.saveAll(recipeModel,recipeTypeModel);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }

    /**
     * 打开编辑页面
     * @param id
     * @param tId
     * @param request
     * @return
     */
    @RequestMapping("/openEditView")
    public String openEditView(String id, String tId, HttpServletRequest request){
        if(StringUtil.isNotEmpty(id)&&StringUtil.isNotEmpty(tId)){
            request.setAttribute("recipe",recipeService.findOne(id));
            request.setAttribute("recipeType",recipeTypeService.findOne(tId));
        }
        TelitUser telitUser=(TelitUser)request.getSession().getAttribute(NameUtil.CURRENT_USER);
        request.setAttribute("schoolName",telitSchoolService.findOne(telitUser.getSchoolId()).getSchoolName());
        return "recipe/recipeEdit";
    }

    /**
     * 食谱编辑保存
     * @param recipeModel
     * @param recipeTypeModel
     * @param tId
     * @return
     */
    @RequestMapping("/recipeEdit")
    @ResponseBody
    public Object recipeEdit(RecipeModel recipeModel, RecipeTypeModel recipeTypeModel,String tId){
        List<Filter> filters = new ArrayList<Filter>();
        recipeTypeModel.setPhoto(StringUtils.strip(JSONObject.parseArray(recipeTypeModel.getPhoto(),String.class).toString(),"[]"));
        filters.add(Filter.eq("schoolId",recipeModel.getSchoolId()));
        filters.add(Filter.eq("weekly",recipeModel.getWeekly()));
        RecipeModel recipe = recipeService.find(filters);
        if(StringUtil.isNotEmpty(tId)){
            RecipeTypeModel rtModel=recipeTypeService.findOne(tId);
            BeanUtil.copyNotNullProperties(rtModel,recipeTypeModel);
            if(BeanUtil.isNotEmpty(recipe)){
                rtModel.setRecipeId(recipe.getId());
                recipeTypeService.save(rtModel);
                return true;
            } else{
                try {
                    recipeService.saveAll(recipeModel,rtModel);
                    return true;
                }catch (Exception e){
                    return false;
                }
            }
        }else{
            return false;
        }
    }

    /**
     * 删除食谱
     * @param ids
     * @return
     */
    @RequestMapping("/recipeDel")
    @ResponseBody
    public Object recipeDel(String ids){
        List<String> list = JSONObject.parseArray(ids,String.class);
        try {
          recipeTypeService.recipeDel(list);
          return true;
        }catch (Exception e){
          return false;
        }
    }
}
