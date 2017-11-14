package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.Tonduty;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TondutyDao extends BaseDao<Tonduty,String> {

    @Query(value = " SELECT CASE a.type WHEN 0 THEN '教室' WHEN 1 THEN '区域' ELSE '' END AS TYPE ," +
            "  d.user_name AS userName ,d.photo" +
            "  FROM t_onduty_detail_student a LEFT JOIN t_onduty_detail b ON a.onduty_detail_id = b.id" +
            "  LEFT JOIN t_onduty c ON b.duty_id = c.id" +
            "  LEFT JOIN vw_class_student d ON a.student_id = d.student_id" +
            "  WHERE b.duty_day =?3 AND c.flag= 1 AND c.class_id =?1 AND c.school_id =?2" +
            "  ORDER BY a.type ASC",nativeQuery = true)
    public List<Object[]> getMembers(String classId, String schoolId, String dutyDay);

    @Query(value = "SELECT  c.user_name as userName,c.photo,a.area" +
            " FROM t_onduty_detail a" +
            " left join  t_onduty b on a.duty_id = b.id " +
            " LEFT JOIN vw_class_student c ON a.student_id = c.student_id" +
            " WHERE a.duty_day =?3" +
            " AND b.flag= 1" +
            " AND b.class_id =?1" +
            " AND b.school_id =?2",nativeQuery = true)
    public List<Object[]> getLeaders(String classId, String schoolId, String dutyDay);
}
