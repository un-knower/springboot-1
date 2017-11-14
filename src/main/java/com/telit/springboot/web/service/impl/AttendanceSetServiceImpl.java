package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.AttendanceDao;
import com.telit.springboot.web.dao.AttendanceSetDao;
import com.telit.springboot.web.model.TattendanceSetting;
import com.telit.springboot.web.service.AttendanceService;
import com.telit.springboot.web.service.AttendanceSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("attendanceSetServiceImpl")
public class AttendanceSetServiceImpl extends BaseServiceImpl<TattendanceSetting,String>implements AttendanceSetService{
    @Autowired
    private AttendanceSetDao attendanceSetDao;

    @Resource(name="attendanceSetDao")
    public void setBaseDao(AttendanceSetDao attendanceSetDao){
        super.setBaseDao(attendanceSetDao);
    }
}
