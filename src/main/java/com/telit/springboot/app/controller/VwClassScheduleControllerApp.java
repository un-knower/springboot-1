package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.filter.Sequencer;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.web.model.VwClassSchedule;
import com.telit.springboot.web.service.VwClassScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课表控制器
 */
@RestController
@RequestMapping("/app/vwClassSchedule")
public class VwClassScheduleControllerApp {

    @Resource(name = "vwClassScheduleServiceImpl")
    private VwClassScheduleService vwClassScheduleService;

    /**
     * 根据班级id课时获取数据
     * @param classId 班级id
     * @param weekly 课时
     * @return
     */
    @RequestMapping("/getScheduleData")
    public ResultMsg getScheduleData(String classId,String weekly){
       List<VwClassSchedule> vcs=vwClassScheduleService.findList(Sequencer.asc("name"),Filter.eq("classId",classId),Filter.eq("weekly",weekly));
       return ResultMsg.sussess("数据获取成功",vcs);
    }
}
