package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.ScheduleModel;

import java.util.List;

public interface ScheduleService extends BaseService<ScheduleModel,String>{
    public List<Object[]> getListByName(String indexName);
    public void scheduleDel( List<String> idList)throws  Exception;

    public List<Object[]> getWeekSchedule(String schoolId,String classId);

    public List<Object[]> getSection(String classId,String weekly);
}
