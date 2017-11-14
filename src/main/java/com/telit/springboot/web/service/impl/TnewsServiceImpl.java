package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TnewsDao;
import com.telit.springboot.web.model.Tnews;
import com.telit.springboot.web.service.TnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tnewsServiceImpl")
public class TnewsServiceImpl extends BaseServiceImpl<Tnews,String>implements TnewsService {
    @Autowired
    private TnewsDao tnewsDao;
    @Resource(name="tnewsDao")
    public void setBaseDao(TnewsDao tnewsDao) {
        super.setBaseDao(tnewsDao);
    }

    public List<Object[]> getNewsByTypeNum(String classId, String typeNum, String deviceId){
        return tnewsDao.getNewsByTypeNum(classId,typeNum,deviceId);
    }


    public List<Object[]> getNewsByTypeNum(String classId, String typeNum){
        return tnewsDao.getNewsByTypeNum(classId,typeNum);
    }
    public List<Object[]> getNewsAndContent(String classId,String schoolId,String newType){
        return tnewsDao.getNewsAndContent( classId, schoolId, newType);
    }
}
