package com.telit.springboot.web.service.impl;

import com.telit.springboot.baseCommon.BaseServiceImpl;
import com.telit.springboot.web.dao.RecipeTypeDao;
import com.telit.springboot.web.dao.ScheduleDao;
import com.telit.springboot.web.model.ScheduleModel;
import com.telit.springboot.web.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("scheduleServiceImpl")
public class ScheduleServiceImpl extends BaseServiceImpl<ScheduleModel,String> implements ScheduleService{
    @Autowired
    private ScheduleDao scheduleDao;

    @Resource(name="scheduleDao")
    public void setBaseDao(ScheduleDao scheduleDao){
        super.setBaseDao(scheduleDao);
    }
    public List<Object[]> getListByName(String indexName){
        return scheduleDao.getListByName(indexName);
    }

    @Transactional
    public void scheduleDel( List<String> idList)throws  Exception{
        if(idList.size()>0&&idList!=null){
            for(String id : idList){
                scheduleDao.delete(id);
            }
        }
    }

    public List<Object[]> getWeekSchedule(String schoolId,String classId){
        return scheduleDao.getWeekSchedule( schoolId, classId);
    }

    public List<Object[]> getSection(String classId,String weekly){
        return scheduleDao.getSection( classId, weekly);
    }
}
