package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.StudentDao;
import com.telit.springboot.web.dao.TdeviceDao;
import com.telit.springboot.web.model.TelitStudent;
import com.telit.springboot.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl extends BaseServiceImpl<TelitStudent,String>implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Resource(name="studentDao")
    public void setBaseDao(StudentDao studentDao) {
        super.setBaseDao(studentDao);
    }

    public List<Object[]> getAllStudent(String classId, String schoolId, String studentName){
        return studentDao.getAllStudent(classId,schoolId,studentName);
    }
}
