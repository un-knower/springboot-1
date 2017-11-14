package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.Tonduty;

import java.util.List;

public interface TondutyService extends BaseService<Tonduty,String>{
    public List<Object[]> getMembers(String classId,String schoolId,String dutyDay);
    public List<Object[]> getLeaders(String classId, String schoolId, String dutyDay);
}
