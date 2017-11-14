package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TmodeUrgentDao;
import com.telit.springboot.web.dao.TtemplateAssignDao;
import com.telit.springboot.web.model.TtemplateAssign;
import com.telit.springboot.web.service.TtemplateAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ttemplateAssignServiceImpl")
public class TtemplateAssignServiceImpl extends BaseServiceImpl<TtemplateAssign,String>implements TtemplateAssignService{
    @Autowired
    private TtemplateAssignDao ttemplateAssignDao;

    @Resource(name="ttemplateAssignDao")
    public void setBaseDao(TtemplateAssignDao ttemplateAssignDao){
        super.setBaseDao(ttemplateAssignDao);
    }
}
