package com.telit.springboot.web.dao;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.web.model.Tnews;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TnewsDao extends BaseDao<Tnews,String> {
    @Query(value = "SELECT a.ID as id ,a.news_type_name as newsTypeName ,a.content_type as contentType ,a.attachment_types as attachmentTypes,a.flag as flag,a.school_id as schoolId" +
            " FROM t_news_type a" +
            " LEFT JOIN class_bander_type_num b ON a.ID = b.news_type_id" +
            " LEFT JOIN t_device c ON b.device_id = c.id " +
            " WHERE c.class_id =?1" +
            " and b.type_num =?2" +
            " AND c.id =?3",nativeQuery = true)
    public List<Object[]> getNewsByTypeNum(String classId, String typeNum, String deviceId);

    @Query(value = "SELECT a.ID as id ,a.news_type_name as newsTypeName ,a.content_type as contentType ,a.attachment_types as attachmentTypes,a.flag as flag,a.school_id as schoolId" +
            " FROM t_news_type a" +
            " LEFT JOIN class_bander_type_num b ON a.ID = b.news_type_id" +
            " LEFT JOIN t_device c ON b.device_id = c.id " +
            " WHERE c.class_id =?1" +
            " and b.type_num =?2",nativeQuery = true)
    public List<Object[]> getNewsByTypeNum(String classId, String typeNum);


    @Query(value = "SELECT n.`ID` AS 'id', n.`news_title` AS 'title',n.`theme_img` AS 'photo' ,c.`news_content` AS 'content',n.`publish_time` AS 'time'" +
            " FROM t_news n LEFT JOIN t_news_content c ON n.`ID`=c.`news_id`" +
            " WHERE n.`class_id`=?1 AND n.`school_id`=?2" +
            " AND n.`news_type`=?3",nativeQuery = true)
    public List<Object[]> getNewsAndContent(String classId,String schoolId,String newType);
}
