package com.telit.springboot.web.service;


import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.EduPosition;

import java.util.List;

public interface EduPositionService extends BaseService<EduPosition,String> {
    public List<Object[]> getAllTeacher(String classId, String schoolId);
}
