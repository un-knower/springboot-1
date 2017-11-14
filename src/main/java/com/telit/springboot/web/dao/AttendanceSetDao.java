package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TattendanceSetting;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceSetDao extends BaseDao<TattendanceSetting,String>{

}
