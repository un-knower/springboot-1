package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TelitStudent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends BaseDao<TelitStudent,String>{

    @Query(value = " SELECT DISTINCT s.user_id AS 'id', s.student_name AS 'userName',s.`date_of_birth` AS 'birthday',GROUP_CONCAT(tp.tel) AS 'phone', tu.`MPHONE_NO` AS 'mphone',u.`photo` AS 'photo' " +
            "  FROM telit_student s LEFT JOIN telit_user u ON s.`user_id`=u.`ID`" +
            "  LEFT JOIN student_parent sp ON s.`ID`=sp.`student_id`" +
            "  LEFT JOIN telit_parent tp ON sp.`parent_id`=tp.`ID`" +
            "  LEFT JOIN telit_user tu ON tu.`ID`=tp.`user_id`" +
            "  WHERE s.`class_id`=:classId AND s.`school_id`=:schoolId AND s.del_flag='0'" +
            "   AND s.student_name LIKE %:studentName%  GROUP BY s.user_id ",nativeQuery = true)
    public List<Object[]> getAllStudent(@Param("classId") String classId,@Param("schoolId") String schoolId,@Param("studentName") String studentName);
}
