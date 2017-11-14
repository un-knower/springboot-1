package com.telit.springboot.app.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.filter.Sequencer;
import com.telit.springboot.util.DateUtil;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.web.model.TmodeUrgent;
import com.telit.springboot.web.model.TmodeUrgentContent;
import com.telit.springboot.web.service.TmodeUrgentContentService;
import com.telit.springboot.web.service.TmodeUrgentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 紧急模式控制器
 */
@RestController
@RequestMapping("/app/tmodeUrgent")
public class TmodeUrgentControllerApp {

    @Resource(name="tmodeUrgentServiceImpl")
    private TmodeUrgentService tmodeUrgentService;

    @Resource(name="tmodeUrgentContentServiceImpl")
    private TmodeUrgentContentService tmodeUrgentContentService;

    /**
     * 获取紧急模式信息
     * @param classId  班级id
     * @return
     */
    @RequestMapping("/findTmodeUrgent")
    public ResultMsg<TmodeUrgent> findTmodeUrgent(String classId){
        List<Filter> filters = new ArrayList<Filter>();
        List<TmodeUrgent> list = tmodeUrgentService.findListByNative(classId,DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_SHORT));
        if(list.size()>0){
            String content =(String)tmodeUrgentContentService.getContent(list.get(0).getId());
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("modeName",list.get(0).getModeName());
            map.put("content",content);
            return ResultMsg.sussess("数据获取成功", ListUtil.oneToList(map));
        }else{
            return ResultMsg.fault("获取数据为空");
        }
    }
}
