package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.ActivityDao;
import com.telit.springboot.web.model.ActivityModel;
import com.telit.springboot.web.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("activityServiceImpl")
public class ActivityServiceImpl extends BaseServiceImpl<ActivityModel,String>implements ActivityService{
    @Autowired
    private ActivityDao activityDao;

    @Resource(name="activityDao")
    public void setBaseDao(ActivityDao activityDao){
        super.setBaseDao(activityDao);
    }
    public List<Object[]> getClassName(String schoolId){
        return activityDao.getClassName(schoolId);
    }

    @Transactional
    public void activityDel(List<String> idList)throws Exception{
        if(idList!=null&&idList.size()>0){
            for(String id:idList){
                activityDao.delete(id);
            }
        }
    }
}
