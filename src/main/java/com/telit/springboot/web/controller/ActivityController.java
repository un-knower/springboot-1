package com.telit.springboot.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.telit.springboot.baseCommon.BaseController;
import com.telit.springboot.filter.DataGrid;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.filter.Page;
import com.telit.springboot.filter.Sequencer;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.ActivityModel;
import com.telit.springboot.web.model.TelitUser;
import com.telit.springboot.web.service.ActivityService;
import com.telit.springboot.web.service.TelitSchoolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 活动控制器
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController{

    @Resource(name = "activityServiceImpl")
    private ActivityService activityService;

    @Resource(name = "telitSchoolServiceImpl")
    private TelitSchoolService telitSchoolService;

    /**
     * 初始化打开活动列表
     * @return
     */
    @RequestMapping("/activityList")
    public String activityList(){
        return "activity/activityList";
    }
    @RequestMapping("/getFrameView")
    public String getFrameView(){
        return "activity/frame";
    }

    /**
     * 获取数据列表
     * @param indexCode
     * @param indexName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getActivityList")
    @ResponseBody
    public Object getActivityList(String indexCode,String indexName,Integer page,Integer rows){
        if(StringUtil.isEmpty(indexName)){
            indexName="";
        }
        List<ActivityModel> list=activityService.findList(Filter.like("title", indexName),Sequencer.desc("playEndDate"));
        return JSONObject.toJSONString(new DataGrid<ActivityModel>(list.size(),page,(List<ActivityModel>)PaginationUtil.pageMap(list,page,rows).get("newList")));
    }

    /**
     * 打开活动新增页面
     * @return
     */
    @RequestMapping("/openAddView")
    public String openAddView(HttpServletRequest request){
        HttpSession session=request.getSession();
        TelitUser telitUser=(TelitUser)session.getAttribute(NameUtil.CURRENT_USER);
        request.setAttribute("schoolName",telitSchoolService.findOne(telitUser.getSchoolId()).getSchoolName());
        request.setAttribute("schoolId",telitUser.getSchoolId());
        return "activity/activityAdd";
    }


    /**
     * 获取所有班级年级名
     * @param request
     * @return
     */
    @RequestMapping("/getClassName")
    @ResponseBody
    public Object getClassName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        TelitUser telitUser = (TelitUser) session.getAttribute(NameUtil.CURRENT_USER);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        if (!BeanUtil.isEmpty(telitUser)) {
            List<Object[]> list = activityService.getClassName(telitUser.getSchoolId());
            for (Object[] obj : list) {
                mapList.add(ListUtil.objectToMap(obj, "classId","gradeName", "className"));
            }
        }
        return mapList;
    }

    /**
     * 活动内容保存
     * @param activityModel
     * @return
     */
    @RequestMapping("/activityAdd")
    @ResponseBody
    public Boolean activityAdd(ActivityModel activityModel,HttpServletRequest request){
        TelitUser telitUser=(TelitUser) request.getSession().getAttribute(NameUtil.CURRENT_USER);
        activityModel.setCreatUser(telitUser.getId().toString());
        List<String> stringList =JSONObject.parseArray(activityModel.getPhoto(),String.class);
        activityModel.setPhoto( StringUtils.strip(stringList.toString(),"[]"));
        activityService.save(activityModel);
        return true;
    }

    /**
     * 打开活动编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/openEditView")
    public String openEditView(String id,ModelMap model){
        if(StringUtil.isNotEmpty(id)){
            ActivityModel activityModel=activityService.findOne(id);
            model.put("activity",activityModel);
            model.put("schoolName",telitSchoolService.findOne(activityModel.getSchoolId()).getSchoolName());
        }
        return "activity/activityEdit";
    }

    /**
     * 编辑活动保存
     * @param activityModel
     * @return
     */
    @RequestMapping(value = "/activityEdit")
    @ResponseBody
    public Object activityEdit(ActivityModel activityModel){
        if(StringUtil.isNotEmpty(activityModel.getId())){
            List<String> list= JSONObject.parseArray(activityModel.getPhoto(),String.class);
            activityModel.setPhoto( StringUtils.strip(list.toString(),"[]"));
            ActivityModel activityl=activityService.findOne(activityModel.getId());
            BeanUtil.copyNotNullProperties(activityl,activityModel);
            activityService.save(activityl);
            return true;
        }
      return false;
    }

    /**
     * 活动删除
     * @param ids
     * @return
     */
    @RequestMapping("/activityDel")
    @ResponseBody
    public Object activityDel(String ids){
        List<String> idList=JSONObject.parseArray(ids,String.class);
        try {
            activityService.activityDel(idList);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
