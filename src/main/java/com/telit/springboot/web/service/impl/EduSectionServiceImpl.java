package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.EduPositionDao;
import com.telit.springboot.web.dao.EduSectionDao;
import com.telit.springboot.web.model.EduSection;
import com.telit.springboot.web.service.EduSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("eduSectionServiceImpl")
public class EduSectionServiceImpl extends BaseServiceImpl<EduSection,String> implements EduSectionService{

    @Autowired
    private EduSectionDao eduSectionDao;

    @Resource(name="eduSectionDao")
    public void setBaseDao(EduSectionDao eduSectionDao){
        super.setBaseDao(eduSectionDao);
    }
}
