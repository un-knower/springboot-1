package com.telit.springboot.app.controller;

import com.telit.springboot.bean.AttandanceBean;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.TattendanceRecord;
import com.telit.springboot.web.model.TattendanceSetting;
import com.telit.springboot.web.model.TelitStudent;
import com.telit.springboot.web.service.AttendanceService;
import com.telit.springboot.web.service.AttendanceSetService;
import com.telit.springboot.web.service.StudentService;
import groovy.transform.ASTTest;
import org.dom4j.io.SAXContentHandler;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 考勤
 */
@RestController
@RequestMapping("/app/attendance")
public class AttendanceControllerApp {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "attendanceSetServiceImpl")
    private AttendanceSetService attendanceSetService;

    @Resource(name = "attendanceServiceImpl")
    private AttendanceService attendanceService;

    @RequestMapping("/getAttendanceList")
    public ResultMsg getAttendanceList(String schoolId,String classId,String cardNumber){
        List<Filter> studentFilter = new ArrayList<Filter>();
        studentFilter.add(Filter.eq("schoolId",schoolId));
        studentFilter.add(Filter.eq("cardNumber1",cardNumber));
        studentFilter.add(Filter.eq("classId",classId));
        TelitStudent telitStudent = studentService.find(studentFilter);
        if(BeanUtil.isEmpty(telitStudent)){
           return ResultMsg.fault("学生不存在，请先注册！");
        }else{
            TattendanceSetting tSetting =attendanceSetService.find(Filter.eq("schoolId",schoolId));
            if(BeanUtil.isEmpty(tSetting)){
                return ResultMsg.fault("该学校未设置考勤时间!");
            }else{
                String currentDate=DateUtil.getCurrentDate(DateUtil.DATE_HOUR_MINUTE);
                List<Filter> filters = new ArrayList<Filter>();
                filters.add(Filter.eq("schoolId",schoolId));
                filters.add(Filter.eq("classId",classId));
                filters.add(Filter.eq("gradeId",telitStudent.getGradeId()));
                filters.add(Filter.eq("studentId",telitStudent.getId()));
                filters.add(Filter.eq("attendaceDate",DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_SHORT)));
                TattendanceRecord tattendanceRecord = attendanceService.find(filters);
                if(DateUtil.isBetweenDate(currentDate,tSetting.getComeFBegin(),tSetting.getComeFEnd(),
                        DateUtil.DATE_HOUR_MINUTE)){
                    if(BeanUtil.isEmpty(tattendanceRecord)){
                        tattendanceRecord=setTattendanceRecord(tattendanceRecord,telitStudent);
                        tattendanceRecord.setComeFirst(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_FULL));
                        if(DateUtil.isBetweenDate(currentDate,tSetting.getComeFBegin(),tSetting.getComeF(),
                                DateUtil.DATE_HOUR_MINUTE)){
                            tattendanceRecord.setFirstResult(NameUtil.ATTENDANCE_ATTEND);
                        }else{
                            tattendanceRecord.setFirstResult(NameUtil.ATTENDANCE_LATE);
                        }
                        attendanceService.save(tattendanceRecord);
                        return ResultMsg.sussess("打卡成功!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                    }else{
                        return ResultMsg.sussess("已经打卡!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                    }
                }else if(DateUtil.isBetweenDate(currentDate,tSetting.getGoFBegin(),tSetting.getGoFEnd(),
                        DateUtil.DATE_HOUR_MINUTE)){
                    if(BeanUtil.isEmpty(tattendanceRecord)){
                        tattendanceRecord=setTattendanceRecord(tattendanceRecord,telitStudent);
                        tattendanceRecord.setFirstResult(NameUtil.ATTENDANCE_EXCEPTION);
                    }else{
                        if(BeanUtil.isEmpty(tattendanceRecord.getGoFirst())){

                        }else{
                            return ResultMsg.sussess("已经打卡!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                        }
                    }
                    tattendanceRecord.setGoFirst(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_FULL));
                    if(DateUtil.isBetweenDate(currentDate,tSetting.getGoFBegin(),tSetting.getGoF(),
                            DateUtil.DATE_HOUR_MINUTE)){
                        tattendanceRecord.setSecondResult(NameUtil.ATTENDANCE_LEAVE_EARLY);
                    }else{
                        tattendanceRecord.setSecondResult(NameUtil.ATTENDANCE_ATTEND);
                    }
                    attendanceService.save(tattendanceRecord);
                    return ResultMsg.sussess("打卡成功!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                }else if(DateUtil.isBetweenDate(currentDate,tSetting.getComeSBegin(),tSetting.getComeSEnd(),
                        DateUtil.DATE_HOUR_MINUTE)){
                    if(BeanUtil.isEmpty(tattendanceRecord)){
                        tattendanceRecord=setTattendanceRecord(tattendanceRecord,telitStudent);
                        tattendanceRecord.setFirstResult(NameUtil.ATTENDANCE_EXCEPTION);
                        tattendanceRecord.setSecondResult(NameUtil.ATTENDANCE_EXCEPTION);
                    }else{
                        if(BeanUtil.isEmpty(tattendanceRecord.getComeSecond())){

                        }else{
                            return ResultMsg.sussess("已经打卡!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                        }
                    }
                    tattendanceRecord.setComeSecond(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_FULL));
                    if(DateUtil.isBetweenDate(currentDate,tSetting.getComeSBegin(),tSetting.getComeS(),
                            DateUtil.DATE_HOUR_MINUTE)){
                        tattendanceRecord.setThirdResult(NameUtil.ATTENDANCE_ATTEND);
                    }else{
                        tattendanceRecord.setThirdResult(NameUtil.ATTENDANCE_LATE);
                    }
                    attendanceService.save(tattendanceRecord);
                    return ResultMsg.sussess("打卡成功!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                }else if(DateUtil.isBetweenDate(currentDate,tSetting.getGoSBegin(),tSetting.getGoSEnd(),
                        DateUtil.DATE_HOUR_MINUTE)){
                    if(BeanUtil.isEmpty(tattendanceRecord)){
                        tattendanceRecord=setTattendanceRecord(tattendanceRecord,telitStudent);
                        tattendanceRecord.setFirstResult(NameUtil.ATTENDANCE_EXCEPTION);
                        tattendanceRecord.setSecondResult(NameUtil.ATTENDANCE_EXCEPTION);
                        tattendanceRecord.setThirdResult(NameUtil.ATTENDANCE_EXCEPTION);
                    }else{
                        if(BeanUtil.isEmpty(tattendanceRecord.getGoSecond())){

                        }else{
                            return ResultMsg.sussess("已经打卡!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                        }
                    }
                    tattendanceRecord.setGoSecond(DateUtil.parse(DateUtil.getCurrentDate(DateUtil.DATE_FORMAT_FULL)));
                    if(DateUtil.isBetweenDate(currentDate,tSetting.getGoSBegin(),tSetting.getGoS(),
                            DateUtil.DATE_HOUR_MINUTE)){
                        tattendanceRecord.setFourthResult(NameUtil.ATTENDANCE_LEAVE_EARLY);
                    }else{
                        tattendanceRecord.setFourthResult(NameUtil.ATTENDANCE_ATTEND);
                    }
                    attendanceService.save(tattendanceRecord);
                    return ResultMsg.sussess("打卡成功!",ListUtil.oneToList( getAttendanceInfo(telitStudent)));
                }else{
                    return ResultMsg.fault("打卡无效!");
                }
            }
        }
    }

    public TattendanceRecord  setTattendanceRecord(TattendanceRecord tattendanceRecord, TelitStudent telitStudent ){
        if(BeanUtil.isEmpty(tattendanceRecord)){
            tattendanceRecord=new TattendanceRecord();
        }
        tattendanceRecord.setClassId(telitStudent.getClassId());
        tattendanceRecord.setGradeId(telitStudent.getGradeId());
        tattendanceRecord.setSchoolId(telitStudent.getSchoolId());
        tattendanceRecord.setAttendaceDate(DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_SHORT));
        tattendanceRecord.setStudentId(telitStudent.getId());
        return tattendanceRecord;
    }


    /**
     * 返回考勤信息
     * @param telitStudent
     * @return
     */
    public Map<String,Object> getAttendanceInfo( TelitStudent telitStudent){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Object[]> objects=attendanceService.getAttendanceInfo(telitStudent.getSchoolId(),telitStudent.getClassId(),telitStudent.getCardNumber1());
        for(Object[] obj : objects){
            map.put("attendance",  ListUtil.objectToMap(obj,"studentName","sex","cardNum","photo",
                    "comeFirst","goFirst","comeSecond","goSecond"));
        }
        map.put("totalCount",studentService.count(
                Filter.eq("schoolId",telitStudent.getSchoolId()),
                Filter.eq("classId",telitStudent.getClassId()),
                Filter.eq("delFlag","0")
        ));
        map.put("actuallyCount",attendanceService.count(Filter.eq("schoolId",telitStudent.getSchoolId()),
                Filter.eq("classId",telitStudent.getClassId()),
                Filter.eq("attendaceDate",DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_SHORT))));
        map.put("laterCount",attendanceService.getLateCount(telitStudent.getSchoolId(),telitStudent.getClassId()));
        map.put("leaveCount",attendanceService.getLeaveCount(telitStudent.getSchoolId(),telitStudent.getClassId()));
        map.put("exceptionCount",attendanceService.getExceptionCount(telitStudent.getSchoolId(),telitStudent.getClassId()));
        return map;
    }


    /**
     * 展示学生模块的考勤列表
     * @return
     */
    @RequestMapping("/getAttendanceDetail")
    public ResultMsg getAttendanceDetail(String schoolId,String classId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalCount",studentService.count(Filter.eq("schoolId",schoolId),
                Filter.eq("classId",classId),
                Filter.eq("delFlag","0")));
        map.put("actuallyCount",attendanceService.count(Filter.eq("schoolId",schoolId),
                Filter.eq("classId",classId),
                Filter.eq("attendaceDate",DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_SHORT))));
        map.put("laterCount",attendanceService.getLateCount(schoolId,classId));
        map.put("leaveCount",attendanceService.getLeaveCount(schoolId,classId));
        map.put("exceptionCount",attendanceService.getExceptionCount(schoolId,classId));
        List<Object[]> studentList= attendanceService.getStudentInfo(schoolId,classId);
        List<Object[]> list= attendanceService.getAttendanceDetail(schoolId,classId);
        Map<String,Object> objectMap = new HashMap<String,Object>();
        Map<String,Object> studentMap = new HashMap<String,Object>();
        List<AttandanceBean> mapList = new ArrayList<AttandanceBean>();
        AttandanceBean attandanceBean;
        for(Object [] student : studentList){
            studentMap=ListUtil.objectToMap(student,"studentName","id","photo");
            for(Object [] obj : list){
                objectMap=ListUtil.objectToMap(obj,"studentName","id","photo","firstResult",
                        "secondResult","thirdResult","fourResult");
                if(!((String)studentMap.get("id")).equals(((String)objectMap.get("id")))){
                    attandanceBean=setAttendance(studentMap);
                    attandanceBean.setStatus("");
                    mapList.add(attandanceBean);
                }else if(NameUtil.ATTENDANCE_EXCEPTION.equals((String)objectMap.get("firstResult"))||
                        NameUtil.ATTENDANCE_EXCEPTION.equals((String)objectMap.get("secondResult"))||
                        NameUtil.ATTENDANCE_EXCEPTION.equals((String)objectMap.get("thirdResult"))||
                        NameUtil.ATTENDANCE_EXCEPTION.equals((String)objectMap.get("fourResult"))){
                    attandanceBean=setAttendance(objectMap);
                    attandanceBean.setStatus(NameUtil.ATTENDANCE_EXCEPTION);
                    mapList.add(attandanceBean);
                }else if(NameUtil.ATTENDANCE_LATE.equals((String)objectMap.get("firstResult"))||
                        NameUtil.ATTENDANCE_LATE.equals((String)objectMap.get("thirdResult"))){
                    attandanceBean=setAttendance(objectMap);
                    attandanceBean.setStatus(NameUtil.ATTENDANCE_LATE);
                    mapList.add(attandanceBean);
                }else if(NameUtil.ATTENDANCE_LEAVE_EARLY.equals((String)objectMap.get("secondResult"))||
                        NameUtil.ATTENDANCE_LEAVE_EARLY.equals((String)objectMap.get("fourResult"))){
                    attandanceBean=setAttendance(objectMap);
                    attandanceBean.setStatus(NameUtil.ATTENDANCE_LEAVE_EARLY);
                    mapList.add(attandanceBean);
                }else{
                    attandanceBean=setAttendance(objectMap);
                    attandanceBean.setStatus(NameUtil.ATTENDANCE_ATTEND);
                    mapList.add(attandanceBean);
                }
            }
        }
        map.put("attendanceList",mapList);
        return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(map));
    }

    public AttandanceBean setAttendance(Map<String,Object> objectMap){
        AttandanceBean attandanceBean=new AttandanceBean();
        attandanceBean.setPhoto((String) objectMap.get("photo"));
        attandanceBean.setStudentName((String)objectMap.get("studentName"));
        return attandanceBean;
    }
}
