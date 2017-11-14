package com.telit.springboot.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.telit.springboot.filter.DataGrid;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.ActivityModel;
import com.telit.springboot.web.model.EduTeacher;
import com.telit.springboot.web.model.ScheduleModel;
import com.telit.springboot.web.model.TelitUser;
import com.telit.springboot.web.service.ScheduleService;
import com.telit.springboot.web.service.TeacherService;
import com.telit.springboot.web.service.TelitSchoolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 周计划控制器
 */
@Controller
@RequestMapping("/schedule")
public class WeekScheduleController {

    @Resource(name = "telitSchoolServiceImpl")
    private TelitSchoolService telitSchoolService;

    @Resource(name = "scheduleServiceImpl")
    private ScheduleService scheduleService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    /**
     * 初始化打开周计划列表
     * @return
     */
    @RequestMapping("/scheduleList")
    public String scheduleList(){
        return "schedule/scheduleList";
    }
    @RequestMapping("/getFrameView")
    public String getFrameView(){
        return "schedule/frame";
    }


    /**
     * 获取数据列表
     * @param indexCode
     * @param indexName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getScheduleList")
    @ResponseBody
    public Object getScheduleList(String indexCode,String indexName,Integer page,Integer rows){
        if(StringUtil.isEmpty(indexName)){
            indexName="";
        }
        List<Object[]> list = scheduleService.getListByName(indexName);
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(Object[] objects:list){
            mapList.add(ListUtil.objectToMap(objects,"id","classId","createUser","createDate","startDate","endDate",
                    "schoolId","fileName"));
        }
        return JSONObject.toJSONString(new DataGrid<Map<String,Object>>(mapList.size(),page,(List<Map<String,Object>>) PaginationUtil.pageMap(mapList,page,rows).get("newList")));
    }

    /**
     * 打开周计划新增页面
     * @return
     */
    @RequestMapping("/openAddView")
    public String openAddView(HttpServletRequest request){
        HttpSession session=request.getSession();
        TelitUser telitUser=(TelitUser)session.getAttribute(NameUtil.CURRENT_USER);
        request.setAttribute("schoolName",telitSchoolService.findOne(telitUser.getSchoolId()).getSchoolName());
        request.setAttribute("schoolId",telitUser.getSchoolId());
        return "schedule/scheduleAdd";
    }

    /**
     * 周计划内容保存
     * @param scheduleModel
     * @return
     */
    @RequestMapping("/scheduleAdd")
    @ResponseBody
    public Boolean activityAdd(ScheduleModel scheduleModel, HttpServletRequest request){
        if(BeanUtil.isEmpty(scheduleModel)){
            return false;
        }
        TelitUser telitUser=(TelitUser) request.getSession().getAttribute(NameUtil.CURRENT_USER);
        scheduleModel.setCreateUser(telitUser.getId().toString());
        scheduleModel.setCreateDate(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_FULL));
        List<String> stringList = JSONObject.parseArray(scheduleModel.getFileUrl(),String.class);
        String path=StringUtils.strip(stringList.toString(),"[]");
        scheduleModel.setFileUrl(path);
        scheduleModel.setFileName(path.split("/")[path.split("/").length-1]);
        scheduleService.save(scheduleModel);
        return true;
    }

    /**
     * 打开编辑页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/openEditView")
    public String openEditView(String id,HttpServletRequest request){
        if(StringUtil.isNotEmpty(id)){
            request.setAttribute("schedule",scheduleService.findOne(id));
        }
        TelitUser telitUser=(TelitUser)request.getSession().getAttribute(NameUtil.CURRENT_USER);
        request.setAttribute("schoolName",telitSchoolService.findOne(telitUser.getSchoolId()).getSchoolName());
        return "schedule/scheduleEdit";
    }
    /**
     * 编辑周计划保存
     * @param scheduleModel
     * @return
     */
    @RequestMapping(value = "/scheduleEdit")
    @ResponseBody
    public Object activityEdit(ScheduleModel scheduleModel){
        if(StringUtil.isNotEmpty(scheduleModel.getId())){
            List<String> list= JSONObject.parseArray(scheduleModel.getFileUrl(),String.class);
            String path=StringUtils.strip(list.toString(),"[]");
            scheduleModel.setFileUrl(path);
            ScheduleModel schedule=scheduleService.findOne(scheduleModel.getId());
            BeanUtil.copyNotNullProperties(schedule,scheduleModel);
            schedule.setCreateDate(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_FULL));
            schedule.setFileName(path.split("/")[path.split("/").length-1]);
            scheduleService.save(schedule);
            return true;
        }
        return false;
    }

    /**
     * 周计划删除
     * @param ids
     * @return
     */
    @RequestMapping("/scheduleDel")
    @ResponseBody
    public Object scheduleDel(String ids){
        List<String> idList=JSONObject.parseArray(ids,String.class);
        try {
            scheduleService.scheduleDel(idList);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
