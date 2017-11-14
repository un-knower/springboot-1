package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.EduSection;
import com.telit.springboot.web.model.EduTeacher;
import com.telit.springboot.web.model.ScheduleModel;
import com.telit.springboot.web.model.VwClassSchedule;
import com.telit.springboot.web.service.EduSectionService;
import com.telit.springboot.web.service.ScheduleService;
import com.telit.springboot.web.service.TeacherService;
import com.telit.springboot.web.service.VwClassScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/app/schedule")
public class ScheduleControllerApp {

    @Resource(name = "scheduleServiceImpl")
    private ScheduleService scheduleService;

    @Resource(name = "vwClassScheduleServiceImpl")
    private VwClassScheduleService vwClassScheduleService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "eduSectionServiceImpl")
    private EduSectionService eduSectionService;

    /**
     * 获取周计划
     * @param schoolId
     * @param classId
     * @return
     */
    @RequestMapping("/getWeekSchedule")
    public ResultMsg getWeekSchedule(String schoolId,String classId){
        List<Object[]> list =scheduleService.getWeekSchedule(schoolId,classId);
        list= ListUtil.isEmpty(list);
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        if(BeanUtil.isEmpty(list)){
            return ResultMsg.fault("数据为空");
        }else{
            for(Object[] obj:list){
                mapList.add(ListUtil.objectToMap(obj,"createUser","fileUrl","fileName"));
            }
            return ResultMsg.sussess("数据获取成功", mapList);
        }
    }

    /**
     * 获取课表
     * @param classId
     * @return
     */
    @RequestMapping("/getSection")
    public ResultMsg getSection(String classId,String schoolId){
        Map<String,Object> map ;
        List<Object[]> list;
        List<Map<String,Object>> mapList =new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> mapList_;
        for(int i=1;i<6;i++){
            list = scheduleService.getSection(classId,String.valueOf(i));
            mapList_ =new ArrayList<Map<String,Object>>();
            for(Object[] objects : list){
                mapList_.add(ListUtil.objectToMap(objects,"id","classId","name","subjectName","teacherName"));
            }
            map = new HashMap<String,Object>();
            map.put(StringUtil.formatter(String.valueOf(i)),mapList_);
            mapList.add(map);
        }
        List<EduSection> eduSections = eduSectionService.findList(Filter.eq("schoolId",schoolId));
        if(eduSections.size()>0&&eduSections!=null){
            mapList.add(new HashMap<String,Object>(){{
                this.put("info",new HashMap<String,Object>(){{
                    this.put("morning",eduSections.get(0).getMorning());
                    this.put("after",eduSections.get(0).getAfternoon());
                    this.put("night",eduSections.get(0).getNight());
                }});
            }});
        }else{
            mapList.add(new HashMap<String,Object>(){{
                this.put("info",new HashMap<String,Object>(){{
                    this.put("morning","");
                    this.put("after","");
                    this.put("night","");
                }});
            }});
        }
        return ResultMsg.sussess("获取数据成功",mapList);
    }
}


