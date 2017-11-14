package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.ActivityModel;

import java.util.List;

public interface ActivityService extends BaseService<ActivityModel,String>{
    public List<Object[]> getClassName(String schoolId);
    public void activityDel(List<String> idList) throws Exception;
}
