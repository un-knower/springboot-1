package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.web.model.TmodeUrgent;

import java.util.List;

public interface TmodeUrgentService extends BaseService<TmodeUrgent,String>{


    List<TmodeUrgent> findListByNative(String classId,String date);
}
