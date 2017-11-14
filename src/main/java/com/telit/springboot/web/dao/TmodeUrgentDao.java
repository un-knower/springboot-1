package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TmodeUrgent;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TmodeUrgentDao extends BaseDao<TmodeUrgent,String>{
    @Query(value = "select * from t_mode_urgent t where 1=1 AND(t.class_id = '' or t.class_id=?1) AND(t.run_flag = '1' or t.valid_begin <= ?2) AND t.valid_end>=?2 order BY t.valid_begin",nativeQuery=true)
    public List<TmodeUrgent> findListByNative(String classId, String date);
}
