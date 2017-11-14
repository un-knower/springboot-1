package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.UserDao;
import com.telit.springboot.web.dao.VwClassBrandInfoDao;
import com.telit.springboot.web.model.VwClassBrandInfo;
import com.telit.springboot.web.service.VwClassBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("vwClassBrandInfoServiceImpl")
public class VwClassBrandInfoServiceImpl extends BaseServiceImpl<VwClassBrandInfo,String>implements VwClassBrandInfoService{
    @Autowired
    private VwClassBrandInfoDao vwClassBrandInfoDao;

    @Resource(name="vwClassBrandInfoDao")
    public void setBaseDao(VwClassBrandInfoDao vwClassBrandInfoDao){
        super.setBaseDao(vwClassBrandInfoDao);
    }
}
