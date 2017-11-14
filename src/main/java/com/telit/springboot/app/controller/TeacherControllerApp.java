package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.EduTeacher;
import com.telit.springboot.web.service.EduPositionService;
import com.telit.springboot.web.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/teacher")
public class TeacherControllerApp {

    @Resource(name = "eduPositionServiceImpl")
    private EduPositionService eduPositionService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    /**
     * 获取教师信息
     * @param classId  班级id
     * @param schoolId 学校id
     * @return
     */
    @RequestMapping("/getAllTeacher")
    public ResultMsg getAllTeacher(String classId,String schoolId){
        List<Object[]> teachers = eduPositionService.getAllTeacher(classId,schoolId);
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object> map ;
        for(Object[] obj : teachers){
            map=new HashMap<String,Object>();
            list.add(ListUtil.objectToMap(obj,"userId","teacher","phone","remark","photo","subjectName"));
        }
        return ResultMsg.sussess("数据获取成功",list);
    }

    /**
     * 获取教师详细信息
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/getTeacherDetail")
    public ResultMsg getTeacherDetail(String userId){
        if(StringUtil.isNotEmpty(userId)){
            EduTeacher eduTeacher = teacherService.find(Filter.eq("userId",userId));
            return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(eduTeacher));
        }
       return ResultMsg.fault("参数为空,数据获取失败");
    }
}
