package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TelitSchoolDao;
import com.telit.springboot.web.dao.TmodeExamDao;
import com.telit.springboot.web.model.TelitSchool;
import com.telit.springboot.web.service.TelitSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("telitSchoolServiceImpl")
public class TelitSchoolServiceImpl extends BaseServiceImpl<TelitSchool,String> implements TelitSchoolService{
    @Autowired
    private TelitSchoolDao telitSchoolDao;

    @Resource(name="telitSchoolDao")
    public void setBaseDao(TelitSchoolDao telitSchoolDao){
        super.setBaseDao(telitSchoolDao);
    }

}
