package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.ScheduleModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleDao extends BaseDao<ScheduleModel,String>{

    @Query(value = "SELECT s.id,s.class_id,s.create_user,s.create_date,s.start_date,s.end_date,s.school_id,s.file_name " +
            " FROM t_schedule s LEFT JOIN edu_teacher t ON s.create_user=t.`user_id` " +
            " WHERE t.`name` LIKE %?1% GROUP BY s.create_date DESC ",nativeQuery = true)
    public List<Object[]> getListByName(String indexName);

    @Query(value="SELECT t.`name`,GROUP_CONCAT(s.file_url SEPARATOR ';') AS 'url',GROUP_CONCAT(s.file_name SEPARATOR ';') AS 'fileName'" +
            " FROM t_schedule s LEFT JOIN edu_teacher t ON s.create_user=t.`user_id` " +
            " WHERE  s.start_date<=NOW() AND s.end_date>=NOW() AND s.class_id=?2 AND s.school_id=?1",nativeQuery = true)
    public List<Object[]> getWeekSchedule(String schoolId,String classId);


    @Query(value = "SELECT s.`ID`,s.`class_id`,s.`name`,s.`subject_name`,s.`teacher_name` " +
            " FROM vw_class_schedule s WHERE s.`class_id`=?1 AND s.`weekly`=?2",nativeQuery = true)
    public List<Object[]> getSection(String classId,String weekly);
}
