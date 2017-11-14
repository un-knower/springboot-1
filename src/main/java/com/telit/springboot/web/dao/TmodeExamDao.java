package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TmodeExam;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TmodeExamDao extends BaseDao<TmodeExam,String>{

    @Query(value = "select * from t_mode_exam t where 1=1 AND(t.class_id = '' or t.class_id=?1)" +
            " AND(t.run_flag = '1' or t.valid_begin < ?2)" +
            " AND t.valid_end>?2 order BY t.valid_begin",nativeQuery=true)
    public List<TmodeExam> findListByNative(String classId, String date);

    @Query(value="SELECT a.id, a.room_number AS roomNumber, b.grade_name AS gradeName, b.class_name AS className FROM t_mode_exam AS a " +
            " INNER JOIN vw_school_class AS b ON a.class_id = b.class_id " +
            " WHERE 1 = 1 AND ( a.run_flag = '1' OR a.valid_begin <?1)" +
            " AND  a.valid_end >?1" +
            " AND a.class_id != ''",nativeQuery = true)
    public List<Object[]> getSchoolDetail(String date);
}
