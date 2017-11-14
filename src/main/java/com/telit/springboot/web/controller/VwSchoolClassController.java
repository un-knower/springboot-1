package com.telit.springboot.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.BeanUtil;
import com.telit.springboot.util.NameUtil;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.EduClass;
import com.telit.springboot.web.model.TelitSchool;
import com.telit.springboot.web.service.EduClassService;
import com.telit.springboot.web.service.EduGradeService;
import com.telit.springboot.web.service.TeacherService;
import com.telit.springboot.web.service.TelitSchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/vw")
public class VwSchoolClassController {
    @Resource(name="telitSchoolServiceImpl")
    private TelitSchoolService telitSchoolService;

    @Resource(name="eduClassServiceImpl")
    private EduClassService eduClassService;

    @Resource(name = "eduGradeServiceImpl")
    private EduGradeService eduGradeService;

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;


    /**
     * 获学校名称
     * @param request
     * @return
     */
    @RequestMapping("/getSchoolName")
    @ResponseBody
    public Object getSchoolName(HttpServletRequest request){
        String schoolId=(String) request.getSession().getAttribute(NameUtil.SCHOOL_ID);
        TelitSchool telitSchool = telitSchoolService.findOne(schoolId);
        return telitSchool;
    }

    /**
     * 获取班级名称
     * @param classId
     * @return
     */
    @RequestMapping("/getClassName")
    @ResponseBody
    public Object getClassName(String classId){
        EduClass eduClass = eduClassService.findOne(classId);
        return eduClass;
    }

    /**
     * 获取年级名
     * @param classId
     * @return
     */
    @RequestMapping("/getGradeName")
    @ResponseBody
    public Object getGradeName(String classId){
        EduClass eduClass = eduClassService.findOne(classId);
        if(BeanUtil.isNotEmpty(eduClass)){
            return  eduGradeService.findOne(Integer.parseInt(eduClass.getGradeId()));
        }
        return null;
    }

    /**
     * 获取教师
     * @param userId
     * @return
     */
    @RequestMapping("/getTeacherName")
    @ResponseBody
    public Object getTeacherName(String userId){
        if(StringUtil.isNotEmpty(userId)){
           return  teacherService.find(Filter.eq("userId",userId));
        }else{
            return null;
        }
    }
}
