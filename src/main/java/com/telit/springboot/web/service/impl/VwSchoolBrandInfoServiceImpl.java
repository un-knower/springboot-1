package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.VwClassBrandInfoDao;
import com.telit.springboot.web.dao.VwSchoolBrandInfoDao;
import com.telit.springboot.web.model.VwSchoolBrandInfo;
import com.telit.springboot.web.service.VwSchoolBrandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("vwSchoolBrandInfoServiceImpl")
public class VwSchoolBrandInfoServiceImpl extends BaseServiceImpl<VwSchoolBrandInfo,String>implements VwSchoolBrandInfoService{
    @Autowired
    private VwSchoolBrandInfoDao vwSchoolBrandInfoDao;

    @Resource(name="vwSchoolBrandInfoDao")
    public void setBaseDao(VwSchoolBrandInfoDao vwSchoolBrandInfoDao){
        super.setBaseDao(vwSchoolBrandInfoDao);
    }
}
