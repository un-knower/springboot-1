package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.TelitStudent;

import java.util.List;

public interface StudentService extends BaseService<TelitStudent,String>{
    public List<Object[]> getAllStudent(String classId, String schoolId, String studentName);
}
