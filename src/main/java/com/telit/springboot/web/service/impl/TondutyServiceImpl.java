package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TondutyDao;
import com.telit.springboot.web.model.Tonduty;
import com.telit.springboot.web.service.TondutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tondutyServiceImpl")
public class TondutyServiceImpl extends BaseServiceImpl<Tonduty,String>implements TondutyService{
    @Autowired
    private TondutyDao tondutyDao;
    @Resource(name="tondutyDao")
    public void setBaseDao(TondutyDao tondutyDao) {
        super.setBaseDao(tondutyDao);
    }
    public List<Object[]> getMembers(String classId, String schoolId, String dutyDay){
        return tondutyDao.getMembers(classId,schoolId,dutyDay);
    }

    public List<Object[]> getLeaders(String classId, String schoolId, String dutyDay){
        return tondutyDao.getLeaders(classId,schoolId,dutyDay);
    }
}
