package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TmodeUrgentDao;
import com.telit.springboot.web.model.TmodeUrgent;
import com.telit.springboot.web.service.TmodeUrgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tmodeUrgentServiceImpl")
public class TmodeUrgentServiceImpl extends BaseServiceImpl<TmodeUrgent,String> implements TmodeUrgentService{
    @Autowired
    private TmodeUrgentDao tmodeUrgentDao;

    @Resource(name="tmodeUrgentDao")
    public void setBaseDao(TmodeUrgentDao tmodeUrgentDao){
        super.setBaseDao(tmodeUrgentDao);
    }

    public List<TmodeUrgent> findListByNative(String classId, String date) {
        return tmodeUrgentDao.findListByNative(classId,date);
    }
}
