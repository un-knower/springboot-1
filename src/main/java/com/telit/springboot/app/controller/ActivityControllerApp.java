package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.DateUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.web.model.ActivityModel;
import com.telit.springboot.web.service.ActivityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/app/activity")
public class ActivityControllerApp {
    @Resource(name = "activityServiceImpl")
    private ActivityService activityService;


    /**
     * 获取最新活动
     * @param classId
     * @param schoolId
     * @return
     */
    @RequestMapping("/getHotActivity")
    public ResultMsg getHotActivity(String classId,String schoolId){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.in("classId",new ArrayList<String>(){{
            this.add("-1");//表示全校级活动
            this.add(classId);
        }}));
        filters.add(Filter.eq("schoolId",schoolId));
        filters.add(Filter.ge("playEndDate", DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_SHORT)));
        List<ActivityModel> list = activityService.findList(filters);
        List<Map<String,Object>> mapList =new ArrayList<Map<String,Object>>();
        Map<String,Object> map;
        for(ActivityModel activityModel:list){
            map=new HashMap<String,Object>();
            map.put("activityModel",activityModel);
            map.put("photo", StringUtils.split(activityModel.getPhoto(),","));
            mapList.add(map);
        }
        return ResultMsg.sussess("数据获取成功",mapList);
    }

    /**
     * 获取历史活动
     * @param classId
     * @param schoolId
     * @return
     */
    @RequestMapping("/getOldActivity")
    public ResultMsg getOldActivity(String classId,String schoolId){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.in("classId",new ArrayList<String>(){{
            this.add("-1");
            this.add(classId);
        }}));
        filters.add(Filter.eq("schoolId",schoolId));
        filters.add(Filter.lt("playEndDate", DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_SHORT)));
        List<ActivityModel> list = activityService.findList(filters);
        List<Map<String,Object>> mapList =new ArrayList<Map<String,Object>>();
        Map<String,Object> map;
        for(ActivityModel activityModel:list){
            map=new HashMap<String,Object>();
            map.put("activityModel",activityModel);
            map.put("photo", StringUtils.split(activityModel.getPhoto(),","));
            mapList.add(map);
        }
        return ResultMsg.sussess("数据获取成功",mapList);
    }
}
