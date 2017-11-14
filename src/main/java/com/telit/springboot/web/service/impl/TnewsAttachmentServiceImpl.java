package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TmodeUrgentDao;
import com.telit.springboot.web.dao.TnewsAttachmentDao;
import com.telit.springboot.web.model.TmodeUrgent;
import com.telit.springboot.web.model.TnewsAttachment;
import com.telit.springboot.web.service.TnewsAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tnewsAttachmentServiceImpl")
public class TnewsAttachmentServiceImpl extends BaseServiceImpl<TnewsAttachment,String>implements TnewsAttachmentService{

    @Autowired
    private TnewsAttachmentDao tnewsAttachmentDao;

    @Resource(name="tnewsAttachmentDao")
    public void setBaseDao(TnewsAttachmentDao tnewsAttachmentDao){
        super.setBaseDao(tnewsAttachmentDao);
    }

}
