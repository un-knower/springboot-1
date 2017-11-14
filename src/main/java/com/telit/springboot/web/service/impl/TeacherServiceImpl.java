package com.telit.springboot.web.service.impl;
import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TeacherDao;
import com.telit.springboot.web.model.EduTeacher;
import com.telit.springboot.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("teacherServiceImpl")
public class TeacherServiceImpl extends BaseServiceImpl<EduTeacher,String> implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;

    @Resource(name="teacherDao")
    public void setBaseDao(TeacherDao teacherDao) {
        super.setBaseDao(teacherDao);
    }

}
