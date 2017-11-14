package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.BeanUtil;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.util.StringUtil;
import com.telit.springboot.web.model.Tdevice;
import com.telit.springboot.web.model.TtemplateAssign;
import com.telit.springboot.web.service.TdeviceService;
import com.telit.springboot.web.service.TtemplateAssignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息控制器
 */
@RestController
@RequestMapping("/app/tdevice")
public class TdeviceControllerApp {
    @Resource(name="tdeviceServiceImpl")
    private TdeviceService tdeviceService;

    @Resource(name="ttemplateAssignServiceImpl")
    private TtemplateAssignService ttemplateAssignService;


    /**
     * 获取设备信息
     * @param uuid  设备唯一标识号
     * @param serial 设备序列号
     * @return
     */
    @RequestMapping("/getTeviceData")
    public ResultMsg getTeviceData(String uuid,String serial){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.eq("uuid",uuid));
        if(StringUtil.isNotEmpty(serial)){
            filters.add(Filter.eq("serial",serial));
        }
        Tdevice tdevice= tdeviceService.find(filters);
        if(!BeanUtil.isEmpty(tdevice)){
            List<Filter> filterList = new ArrayList<Filter>();
            filterList.add(Filter.eq("schoolId",tdevice.getSchoolId()));
            filterList.add(Filter.eq("classId",tdevice.getClassId()));
            TtemplateAssign template = ttemplateAssignService.find(filterList);
            return ResultMsg.sussess("获取数据成功",ListUtil.oneToList(template));
        }else{
            return ResultMsg.fault("请先注册！");
        }
    }
}
