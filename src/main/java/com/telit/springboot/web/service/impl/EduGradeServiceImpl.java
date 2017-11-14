package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.EduClassDao;
import com.telit.springboot.web.dao.EduGradeDao;
import com.telit.springboot.web.model.EduGrade;
import com.telit.springboot.web.model.EduGradeFixed;
import com.telit.springboot.web.service.EduGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("eduGradeServiceImpl")
public class EduGradeServiceImpl extends BaseServiceImpl<EduGradeFixed,Integer>implements EduGradeService{
    @Autowired
    private EduGradeDao eduGradeDao;

    @Resource(name="eduGradeDao")
    public void setBaseDao(EduGradeDao eduGradeDao){
        super.setBaseDao(eduGradeDao);
    }
}
