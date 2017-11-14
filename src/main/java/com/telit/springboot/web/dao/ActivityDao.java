package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.ActivityModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityDao extends BaseDao<ActivityModel,String>{

    @Query(value = "  SELECT c.id AS 'id', g.name AS 'gradeName',c.class_name AS 'className' FROM edu_class c LEFT JOIN edu_grade_fixed g ON g.id=c.grade_id" +
            "    WHERE c.school_id=?1 AND c.del_flag='0' ORDER BY g.id ASC ,c.class_name ASC",nativeQuery = true)
    public List<Object[]> getClassName(String schoolId);
}
