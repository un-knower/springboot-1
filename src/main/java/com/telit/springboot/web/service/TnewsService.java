package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.Tnews;

import java.util.List;

public interface TnewsService extends BaseService<Tnews,String> {
    public List<Object[]> getNewsByTypeNum(String classId,String typeNum,String deviceId);
    public List<Object[]> getNewsByTypeNum(String classId, String typeNum);
    public List<Object[]> getNewsAndContent(String classId,String schoolId,String newType);
}
