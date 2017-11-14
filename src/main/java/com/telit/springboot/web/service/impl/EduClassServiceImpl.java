package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.EduClassDao;
import com.telit.springboot.web.dao.EduPositionDao;
import com.telit.springboot.web.model.EduClass;
import com.telit.springboot.web.service.EduClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("eduClassServiceImpl")
public class EduClassServiceImpl extends BaseServiceImpl<EduClass,String> implements EduClassService{


    @Autowired
    private EduClassDao eduClassDao;

    @Resource(name="eduClassDao")
    public void setBaseDao(EduClassDao eduClassDao){
        super.setBaseDao(eduClassDao);
    }
}
