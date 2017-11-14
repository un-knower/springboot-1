package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.TmodeExam;

import java.util.List;
import java.util.Map;

public interface TmodeExamService extends BaseService<TmodeExam,String>{
    public List<TmodeExam> findListByNative(String classId, String date);
    public List<Object[]> getSchoolDetail(String date);
}
