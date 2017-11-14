package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.TelitStudent;
import com.telit.springboot.web.service.StudentService;
import com.telit.springboot.web.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app/student")
public class StudentControllerApp {

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    /**
     * 获取学生信息列表
     * @param classId     班级id
     * @param schoolId    学校id
     * @param studentName 学生姓名
     * @return
     */
    @RequestMapping("/getAllStudent")
    public ResultMsg getAllStudent(String classId,String schoolId,String studentName){
        List<Object[]> list = studentService.getAllStudent(classId,schoolId,studentName.trim());
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(Object[] obj : list){
            mapList.add(ListUtil.objectToMap(obj,"id","userName","birthday","phone","mphone","photo"));
        }
        return ResultMsg.sussess("数据获取成功",mapList);
    }

    /**
     * 获取学生详细信息
     * @param userId  用户id
     * @return
     */
    @RequestMapping("/getStudentDetail")
    public ResultMsg getStudentDetail(String userId){
        if(StringUtil.isNotEmpty(userId)){
            TelitStudent student=studentService.find(Filter.eq("userId",userId));
            return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(student));
        }else{
            return ResultMsg.fault("参数为空,数据获取失败");
        }
    }
}
