package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.VwClassScheduleDao;
import com.telit.springboot.web.model.VwClassSchedule;
import com.telit.springboot.web.service.VwClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("vwClassScheduleServiceImpl")
public class VwClassScheduleServiceImpl extends BaseServiceImpl<VwClassSchedule,String>implements VwClassScheduleService{

    @Autowired
    private VwClassScheduleDao vwClassScheduleDao;

    @Resource(name="vwClassScheduleDao")
    public void setBaseDao(VwClassScheduleDao vwClassScheduleDao){
        super.setBaseDao(vwClassScheduleDao);
    }
}
