package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TmodeExamDao;
import com.telit.springboot.web.model.TmodeExam;
import com.telit.springboot.web.service.TmodeExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("tmodeExamServiceImpl")
public class TmodeExamServiceImpl extends BaseServiceImpl<TmodeExam,String>implements TmodeExamService{
    @Autowired
    private TmodeExamDao tmodeExamDao;

    @Resource(name="tmodeExamDao")
    public void setBaseDao(TmodeExamDao tmodeExamDao){
        super.setBaseDao(tmodeExamDao);
    }

    public List<TmodeExam> findListByNative(String classId, String date) {
        return tmodeExamDao.findListByNative(classId,date);
    }
    public List<Object[]> getSchoolDetail(String date){
        return tmodeExamDao.getSchoolDetail(date);
    }
}
