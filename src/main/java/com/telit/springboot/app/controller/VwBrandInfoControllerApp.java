package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.web.model.VwClassBrandInfo;
import com.telit.springboot.web.model.VwSchoolBrandInfo;
import com.telit.springboot.web.service.VwClassBrandInfoService;
import com.telit.springboot.web.service.VwSchoolBrandInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 信息控制器
 */
@RestController
@RequestMapping("/app/vwBrandInfo")
public class VwBrandInfoControllerApp {

    @Resource(name = "vwClassBrandInfoServiceImpl")
    private VwClassBrandInfoService vwClassBrandInfoService;

    @Resource(name="vwSchoolBrandInfoServiceImpl")
    private VwSchoolBrandInfoService vwSchoolBrandInfoService;

    /**
     * 班牌获取信息
     * @param classId
     * @param schoolId
     * @return
     */
    @RequestMapping("/getClassData")
    public ResultMsg getClassData(String classId,String schoolId){
        VwClassBrandInfo vc=vwClassBrandInfoService.find(Filter.eq("schoolId",schoolId),Filter.eq("classId",classId));
        return ResultMsg.sussess("数据获取成功", ListUtil.oneToList(vc));
    }

    /**
     * 校牌获取信息
     * @param classId
     * @param schoolId
     * @return
     */
    @RequestMapping("/getSchoolData")
    public ResultMsg getSchoolData(String classId,String schoolId){
       VwSchoolBrandInfo vs= vwSchoolBrandInfoService.find(Filter.eq("schoolId",schoolId),Filter.eq("classId",classId));
       return ResultMsg.sussess("数据获取成功", ListUtil.oneToList(vs));
    }
}
