package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.TmodeUrgentContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

public interface TmodeUrgentContentDao extends BaseDao<TmodeUrgentContent,String>{
    @Query(value = "SELECT u.`urgent_content` FROM t_mode_urgent_content u " +
            " WHERE u.`urgen_id`=?1",nativeQuery = true)
    public Object getContent(String urgentId);
}
