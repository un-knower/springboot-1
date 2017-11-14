package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.ActivityDao;
import com.telit.springboot.web.dao.AttendanceDao;
import com.telit.springboot.web.model.TattendanceRecord;
import com.telit.springboot.web.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("attendanceServiceImpl")
public class AttendanceServiceImpl extends BaseServiceImpl<TattendanceRecord,String>implements AttendanceService{
    @Autowired
    private AttendanceDao attendanceDao;

    @Resource(name="attendanceDao")
    public void setBaseDao(AttendanceDao attendanceDao){
        super.setBaseDao(attendanceDao);
    }
    public List<Object[]> getAttendanceInfo(String schoolId, String classId, String cardNumber){
        return attendanceDao.getAttendanceInfo(schoolId,classId,cardNumber);
    }

    public long getLateCount(String schoolId,String classId){
        return attendanceDao.getLateCount(schoolId,classId);
    }

    public long getLeaveCount(String schoolId,String classId){
        return attendanceDao.getLeaveCount(schoolId,classId);
    }
    public long getExceptionCount(String schoolId,String classId){
        return attendanceDao.getExceptionCount(schoolId,classId);
    }

    public List<Object[]> getAttendanceDetail(String schoolId,String classId){
        return attendanceDao.getAttendanceDetail(schoolId,classId);
    }

    public List<Object[]> getStudentInfo(String schoolId,String classId){
        return attendanceDao.getStudentInfo(schoolId,classId);
    }
}
