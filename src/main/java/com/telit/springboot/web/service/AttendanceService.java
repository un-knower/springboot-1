package com.telit.springboot.web.service;

import com.telit.springboot.baseCommon.BaseService;
import com.telit.springboot.web.model.TattendanceRecord;

import java.util.List;

public interface AttendanceService extends BaseService<TattendanceRecord,String>{
    public List<Object[]> getAttendanceInfo(String schoolId, String classId, String cardNumber);

    public long getLateCount(String schoolId,String classId);

    public long getLeaveCount(String schoolId,String classId);

    public long getExceptionCount(String schoolId,String classId);

    public List<Object[]> getAttendanceDetail(String schoolId,String classId);

    public List<Object[]> getStudentInfo(String schoolId,String classId);
}
