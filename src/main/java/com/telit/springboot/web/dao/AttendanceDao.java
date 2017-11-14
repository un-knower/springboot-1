package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TattendanceRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceDao extends BaseDao<TattendanceRecord,String>{

    @Query(value = "SELECT s.`student_name` as 'studentName',s.`sex` as 'sex',s.`card_number1` AS 'cardNum'," +
            "   u.`photo` as 'photo',a.`come_first` AS  'comeFirst'," +
            " a.`go_first` AS 'goFirst',a.`come_second` AS 'comeSecond',a.`go_second` as 'goSecond' FROM telit_student s LEFT JOIN t_attendance_record a ON s.`ID`=a.`student_id`" +
            " LEFT JOIN telit_user u ON u.`ID`=s.`user_id`" +
            " WHERE s.`card_number1`=?3" +
            " AND s.`school_id`=?1 AND s.`class_id`=?2 AND a.`attendace_date`=CURDATE()",nativeQuery = true)
    public List<Object[]> getAttendanceInfo(String schoolId, String classId, String cardNumber);

    @Query(value = "SELECT COUNT(*) FROM t_attendance_record a " +
            " WHERE a.`class_id`=?2" +
            " AND a.`school_id`=?1  AND(a.`first_result`='迟到' OR a.`third_result`='迟到')" +
            " AND a.`attendace_date`=CURDATE()",nativeQuery = true)
    public long getLateCount(String schoolId,String classId);

    @Query(value = "SELECT COUNT(*) FROM t_attendance_record a " +
            " WHERE a.`class_id`=?2" +
            " AND a.`school_id`=?1  AND(a.`second_result`='早退' OR a.`fourth_result`='早退')" +
            " AND a.`attendace_date`=CURDATE()",nativeQuery = true)
    public long getLeaveCount(String schoolId,String classId);


    @Query(value = "SELECT COUNT(*) FROM t_attendance_record a " +
            " WHERE a.`class_id`=?2" +
            " AND a.`school_id`=?1  AND( a.`first_result`='异常' OR  a.`second_result`='异常' " +
            " OR a.`third_result`='异常' OR a.`fourth_result`='异常')" +
            " AND a.`attendace_date`=CURDATE()",nativeQuery = true)
    public long getExceptionCount(String schoolId,String classId);


    @Query(value = "SELECT s.`student_name`,s.id,u.`photo`,r.`first_result`,r.`second_result`,r.`third_result`,r.`fourth_result`" +
            " FROM telit_student s " +
            " LEFT JOIN t_attendance_record r ON s.`ID`=r.`student_id` LEFT JOIN telit_user u ON u.`ID`=s.`user_id` " +
            " WHERE s.`class_id`=?2 AND s.`school_id`=?1" +
            " AND r.`attendace_date`=CURDATE()",nativeQuery = true)
    public List<Object[]> getAttendanceDetail(String schoolId,String classId);

    @Query(value = "SELECT s.`student_name`,s.id,u.`photo`" +
            " FROM telit_student s " +
            "  LEFT JOIN telit_user u ON u.`ID`=s.`user_id` " +
            "  WHERE s.`class_id`=?2 AND s.`school_id`=?1",nativeQuery = true)
    public List<Object[]> getStudentInfo(String schoolId,String classId);

}
