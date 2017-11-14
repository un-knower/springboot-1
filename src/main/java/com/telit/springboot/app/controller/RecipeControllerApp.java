package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.BeanUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.RecipeModel;
import com.telit.springboot.web.model.RecipeTypeModel;
import com.telit.springboot.web.service.RecipeService;
import com.telit.springboot.web.service.RecipeTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/recipe")
public class RecipeControllerApp {
    @Resource(name = "recipeServiceImpl")
    private RecipeService recipeService;

    @Resource(name="recipeTypeServiceImpl")
    private RecipeTypeService recipeTypeService;


    /**
     * 获取食谱
     * @param schoolId
     * @return
     */
    @RequestMapping("/getRecipeList")
    public ResultMsg getRecipeList(String schoolId) {
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.eq("schoolId",schoolId));
        List<RecipeModel> recipeModelList=recipeService.findList(filters);
        if(recipeModelList==null||recipeModelList.size()==0){
           return  ResultMsg.fault("查询失败");
        }else{
            List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
            List<RecipeTypeModel> recipeTypeModelList;
            Map<String ,Object> map;
            Map<String ,Object> map_;
            List<Map<String,Object>> mapList_;
            for(RecipeModel recipeModel : recipeModelList){
                map=new HashMap<String,Object>();
                map_=new HashMap<String,Object>();
                mapList_=new ArrayList<Map<String,Object>>();
                recipeTypeModelList=recipeTypeService.findList(Filter.eq("recipeId",recipeModel.getId()),Filter.eq("mealType","0"));
                map.put("dessert",recipeTypeModelList);
                recipeTypeModelList=recipeTypeService.findList(Filter.eq("recipeId",recipeModel.getId()),Filter.eq("mealType","1"));
                map.put("dinner",recipeTypeModelList);
                mapList_.add(map);
                map_.put(StringUtil.formatter(recipeModel.getWeekly()),mapList_);
                mapList.add(map_);
            }
            return ResultMsg.sussess("数据获取成功",mapList);
        }
    }


}
