package com.telit.springboot.web.service.impl;


import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.EduPositionDao;
import com.telit.springboot.web.model.EduPosition;
import com.telit.springboot.web.service.EduPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("eduPositionServiceImpl")
public class EduPositionServiceImpl extends BaseServiceImpl<EduPosition,String> implements EduPositionService {

    @Autowired
    private EduPositionDao eduPositionDao;

    @Resource(name="eduPositionDao")
    public void setBaseDao(EduPositionDao eduPositionDao){
        super.setBaseDao(eduPositionDao);
    }

    public List<Object[]> getAllTeacher(String classId, String schoolId){
        return eduPositionDao.getAllTeacher(classId,schoolId);
    }
}
