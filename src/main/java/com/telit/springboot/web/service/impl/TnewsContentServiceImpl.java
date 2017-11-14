package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TnewsContentDao;
import com.telit.springboot.web.dao.TnewsDao;
import com.telit.springboot.web.model.TnewsContent;
import com.telit.springboot.web.service.TnewsContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tnewsContentServiceImpl")
public class TnewsContentServiceImpl extends BaseServiceImpl<TnewsContent,String>implements TnewsContentService {
    @Autowired
    private TnewsContentDao tnewsContentDao;

    @Resource(name = "tnewsContentDao")
    public void setBaseDao(TnewsContentDao tnewsContentDao){
        super.setBaseDao(tnewsContentDao);
    }


}
