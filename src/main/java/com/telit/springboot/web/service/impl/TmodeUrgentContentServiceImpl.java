package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TmodeUrgentContentDao;
import com.telit.springboot.web.dao.TmodeUrgentDao;
import com.telit.springboot.web.model.TmodeUrgentContent;
import com.telit.springboot.web.service.TmodeUrgentContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tmodeUrgentContentServiceImpl")
public class TmodeUrgentContentServiceImpl extends BaseServiceImpl<TmodeUrgentContent,String>implements TmodeUrgentContentService {
    @Autowired
    private TmodeUrgentContentDao tmodeUrgentContentDao;

    @Resource(name="tmodeUrgentContentDao")
    public void setBaseDao(TmodeUrgentContentDao tmodeUrgentContentDao){
        super.setBaseDao(tmodeUrgentContentDao);
    }
    public Object getContent(String urgentId){
        return tmodeUrgentContentDao.getContent(urgentId);
    }
}
