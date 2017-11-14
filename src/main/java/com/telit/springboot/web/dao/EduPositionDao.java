package com.telit.springboot.web.dao;


import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.EduPosition;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EduPositionDao extends BaseDao<EduPosition, String> {
    @Query(value = "SELECT t.id AS 'userId' ,t.`USER_NAME` AS 'teacher',et.phone AS  'phone',et.remark AS  'remark',t.`photo`AS 'photo',GROUP_CONCAT(s.`subject_name`) AS 'subjectName'" +
            "  FROM edu_position e LEFT JOIN edu_subject s ON e.`subject_id`=s.`ID`" +
            "  LEFT JOIN telit_user t ON t.id=e.`position_user`" +
            "  left JOIN edu_teacher et ON e.`position_user`=et.user_id"+
            "  WHERE e.`relation_id`=?1 AND e.`position_type`='3'" +
            "  AND t.`SCHOOL_ID`=?2 GROUP BY  t.id",nativeQuery = true)
    public List<Object[]> getAllTeacher(String classId,String schoolId);
}
