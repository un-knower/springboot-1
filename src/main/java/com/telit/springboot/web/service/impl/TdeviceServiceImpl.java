package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseDao;
import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.TdeviceDao;
import com.telit.springboot.web.model.Tdevice;
import com.telit.springboot.web.service.TdeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tdeviceServiceImpl")
public class TdeviceServiceImpl extends BaseServiceImpl<Tdevice,String> implements TdeviceService{
    @Autowired
    private TdeviceDao tdeviceDao;

    @Resource(name="tdeviceDao")
    public void setBaseDao(TdeviceDao tdeviceDao) {
        super.setBaseDao(tdeviceDao);
    }
}
