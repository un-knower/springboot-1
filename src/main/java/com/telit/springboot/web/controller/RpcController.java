package com.telit.springboot.web.controller;

import cn.jpush.api.JPushClient;
import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.BeanUtil;
import com.telit.springboot.util.JpushUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.Tdevice;
import com.telit.springboot.web.model.TmodeUrgent;
import com.telit.springboot.web.service.TdeviceService;
import com.telit.springboot.web.service.TmodeUrgentContentService;
import com.telit.springboot.web.service.TmodeUrgentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供远程调用
 */
@Controller
@RequestMapping("/rpc")
public class RpcController {

    @Value("${appKey}")
    private String appKey;
    @Value("${masterSecret}")
    private String masterSecret;

    @Resource(name = "tdeviceServiceImpl")
    private TdeviceService tdeviceService;

    @Resource(name = "tmodeUrgentServiceImpl")
    private TmodeUrgentService tmodeUrgentService;

    @Resource(name = "tmodeUrgentContentServiceImpl")
    private TmodeUrgentContentService tmodeUrgentContentService;

    /**
     * 开启紧急模式
     * @return
     */
    @RequestMapping("/startUrgent")
    @ResponseBody
    public String startUrgent(String schoolId,String classId,String id){
        Map<String,String> map = new HashMap<String,String>();
        if(StringUtil.isNotEmpty(id)){
            TmodeUrgent tmodeUrgent =tmodeUrgentService.findOne(id);
            map.put("urgentTitle",tmodeUrgent.getModeName());//紧急模式的标题
            //紧急模式的内容
            if(StringUtil.isNotEmpty((String)tmodeUrgentContentService.getContent(id))){
                map.put("urgentContent",(String)tmodeUrgentContentService.getContent(id));
            }else{
                map.put("urgentContent","");
            }

        }
        map.put("message","1");
        JpushUtil.sendAllsetNotification("开启紧急模式",appKey,masterSecret,getAliasList(schoolId,classId),map);
        return null;
    }


    /**
     * 关闭紧急模式
     * @return
     */
    @RequestMapping("/endUrgent")
    @ResponseBody
    public String endUrgent(String schoolId,String classId,String id){
        Map<String,String> map = new HashMap<String,String>();
        map.put("message","0");
        map.put("urgentContent","");
        map.put("urgentTitle","");
        JpushUtil.sendAllsetNotification("关闭紧急模式",appKey,masterSecret,getAliasList(schoolId,classId),map);
        return null;
    }


    /**
     * 获取要推送的别名集合
     * @param schoolId
     * @param classId
     * @return
     */
    public List<String> getAliasList(String schoolId,String classId){
        List<String> list;
        if(StringUtil.isEmpty(classId)){
            list = new ArrayList<String>();
            List<Tdevice> tdeviceList= tdeviceService.findList(Filter.eq("schoolId",schoolId));
            for(Tdevice tdevice : tdeviceList){
                list.add(tdevice.getUuid());
            }
        }else{
            Tdevice tdevice= tdeviceService.find(Filter.eq("schoolId",schoolId),Filter.eq("classId",classId));
            list = new ArrayList<String>();
            list.add( tdevice.getUuid());
        }
        return list;
    }
}
