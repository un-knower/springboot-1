package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.util.ListUtil;
import com.telit.springboot.util.ResultMsg;
import com.telit.springboot.web.model.TtemplateAssign;
import com.telit.springboot.web.service.TtemplateAssignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模版控制器
 */
@RestController
@RequestMapping("/app/ttemplateAssign")
public class TtemplateAssignControllerApp {

    @Resource(name = "ttemplateAssignServiceImpl")
    private TtemplateAssignService ttemplateAssignService;

    /**
     * 根据班级和学校id获取模版类型
     * @param classId 班级id
     * @param schoolId 学校id
     * @return
     */
    @RequestMapping("/getTtemplateAssignList")
    public ResultMsg getTtemplateAssignList(String classId,String schoolId){
        List<TtemplateAssign> assignList=ttemplateAssignService.findList(Filter.eq("schoolId",schoolId),Filter.eq("classId",classId));
        if(assignList!=null&&assignList.size()>0){
            return ResultMsg.sussess("数据获取成功", ListUtil.oneToList(assignList.get(0)));
        }
        return ResultMsg.fault("数据为空");
    }
}
