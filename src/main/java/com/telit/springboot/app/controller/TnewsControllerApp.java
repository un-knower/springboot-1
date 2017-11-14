package com.telit.springboot.app.controller;

import com.telit.springboot.filter.Filter;
import com.telit.springboot.filter.Sequencer;
import com.telit.springboot.util.*;
import com.telit.springboot.web.model.*;
import com.telit.springboot.web.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 新闻控制器
 */
@RestController
@RequestMapping("/app/tnews")
public class TnewsControllerApp {

    @Resource(name = "tnewsServiceImpl")
    private TnewsService tnewsService;

    @Resource(name = "tnewsContentServiceImpl")
    private TnewsContentService tnewsContentService;

    @Resource(name = "tnewsAttachmentServiceImpl")
    private TnewsAttachmentService tnewsAttachmentService;

    @Resource(name = "eduClassServiceImpl")
    private EduClassService eduClassService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @Resource(name = "attendanceSetServiceImpl")
    private AttendanceSetService attendanceSetService;

    @Resource(name = "attendanceServiceImpl")
    private AttendanceService attendanceService;

    @Resource(name = "activityServiceImpl")
    private ActivityService activityService;

    @Resource(name = "recipeServiceImpl")
    private RecipeService recipeService;

    @Resource(name="recipeTypeServiceImpl")
    private RecipeTypeService recipeTypeService;

    @Resource(name = "vwClassBrandInfoServiceImpl")
    private VwClassBrandInfoService vwClassBrandInfoService;

    /**
     * 获取信息
     * @param classId 班级id
     * @param deviceId 设备id
     * @param typeNum 信息类型
     * @param schoolId 学校id
     * @return
     */
    @RequestMapping("/getNewsByTypeNum")
    public ResultMsg getNewsByTypeNum(String classId,String deviceId,String typeNum,String schoolId)
    {
        List<Object[]> list=new ArrayList<Object[]>();
        if (StringUtil.isNotEmpty(deviceId)){
            list=tnewsService.getNewsByTypeNum(classId,typeNum,deviceId);
        }else{
            list=tnewsService.getNewsByTypeNum(classId,typeNum);
        }
        if(list.size()>0&&list!=null){
            Map<String,Object> objectMap=ListUtil.objectToMap(list.get(0),"id","newsTypeName","contentType","attachmentTypes","flag","schoolId");
            Map<String,Object> map =new HashMap<String,Object>();
            map.put("newsType",objectMap);
            List<Filter> filterlist=new ArrayList<Filter>();
            filterlist.add(Filter.eq("newsType",objectMap.get("id")));
            filterlist.add(Filter.eq("schoolId",schoolId));
            filterlist.add(Filter.in("classId",new ArrayList<String>(){{
                this.add("");
                this.add(classId);
            }}));
            filterlist.add(Filter.le("publishTime", DateUtil.getCurrentDate(DateUtil.DATE_FORMAT_SHORT)));
            List<Tnews> tnews=tnewsService.findList(filterlist,Sequencer.desc("publishTime"));
            map.put("tnews",tnews);
            return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(map));
        }
        return ResultMsg.fault("数据为空");
    }

    /**
     * 获取信息列表根据信息类型
     * @param classId 班级id
     * @param schoolId 学校id
     * @param newsType 信息类型
     * @return
     */
    @RequestMapping("/getNewsByNewsType")
    public ResultMsg getNewsByNewsType(String classId,String schoolId,String newsType){
        return ResultMsg.sussess("数据获取成功",getNews(classId,schoolId,newsType));
    }

    /**
     * 一次性获取首页所有内容
     * @param classId
     * @param schoolId
     * @return
     */
    @RequestMapping("/getAllNews")
    public ResultMsg getAllNews(String classId,String schoolId){
        Map<String,Object>map= new HashMap<String,Object>();
        //1 表示 通知公告 2 表示 视频播放 3 表示 荣誉墙 4 表示 班级荣誉 5 表示 班级风采 6 表示 教师风采 7 表示 校园风采 8 表示 学生风采
        for(int i=1;i<9;i++){
            map.put(StringUtil.formatter(String.valueOf(i)),getNews(classId,schoolId,String.valueOf(i)));
        }
        map.put("totalCount",studentService.count(Filter.eq("schoolId",schoolId),
                Filter.eq("classId",classId),  Filter.eq("delFlag","0")
        ));
        map.put("actuallyCount",attendanceService.count(Filter.eq("schoolId",schoolId),
                Filter.eq("classId",classId),
                Filter.eq("attendaceDate",DateUtil.date2Date(new Date(),DateUtil.DATE_FORMAT_SHORT))));
        map.put("laterCount",attendanceService.getLateCount(schoolId,classId));
        map.put("leaveCount",attendanceService.getLeaveCount(schoolId,classId));
        map.put("exceptionCount",attendanceService.getExceptionCount(schoolId,classId));
        map.put("hotActivity",getHotActivity(classId,schoolId));
        map.put("recipe",getRecipe(schoolId));
        map.put("classData",vwClassBrandInfoService.find(Filter.eq("schoolId",schoolId),
                Filter.eq("classId",classId)));
        return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(map));
    }


    /**
     * 首页获取食谱
     */
    public Map<String,Object> getRecipe(String schoolId){
        int week = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;
        //周六周日展示周五的食谱
        if(week==0||week==7){
            week=5;
        }
       RecipeModel recipeModel=recipeService.find(Filter.eq("schoolId",schoolId),Filter.eq("weekly",week));
       Map<String,Object> map = new HashMap<String,Object>();
       if(BeanUtil.isNotEmpty(recipeModel)){
           List<RecipeTypeModel> dessertList=recipeTypeService.findList(Filter.eq("recipeId",recipeModel.getId()),Filter.eq("mealType","0"));
           map.put("dessert",dessertList);
           List<RecipeTypeModel> dinnerList=recipeTypeService.findList(Filter.eq("recipeId",recipeModel.getId()),Filter.eq("mealType","1"));
           map.put("dinner",dinnerList);
       }
       return map;
    }

    /**
     * 首页获取最新活动
     * @param classId
     * @param schoolId
     * @return
     */
    public  List<ActivityModel> getHotActivity(String classId,String schoolId){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.in("classId",new ArrayList<String>(){{
            this.add("-1");//表示全校级活动
            this.add(classId);
        }}));
        filters.add(Filter.eq("schoolId",schoolId));
        filters.add(Filter.ge("playEndDate", DateUtil.date2Str(new Date(),DateUtil.DATE_FORMAT_SHORT)));
        List<ActivityModel> list = activityService.findList(filters);
        return list;
    }


    /**
     *公用--
     *根据信息类型获取信息列表
     */
    public  List<Map<String,Object>> getNews(String classId,String schoolId,String newsType){
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.in("classId",new ArrayList<String>(){{
            this.add("");
            this.add(classId);
        }}));
        filters.add(Filter.eq("schoolId",schoolId));
        filters.add(Filter.eq("newsType",newsType));
        List<Tnews> tnewsList = tnewsService.findList(filters, Sequencer.desc("publishTime"));
        List<Map<String,Object>> mapList =new ArrayList<Map<String,Object>>();
        Map<String,Object> map;
        for(Tnews tnews : tnewsList){
            map=new HashMap<String,Object>();
            map.put("tnews",tnews);
            map.put("tnewsAttachment",tnewsAttachmentService.find(Filter.eq("newsId",tnews.getId())));
            TnewsContent tnewsContent =tnewsContentService.find(Filter.eq("newsId",tnews.getId()));
            map.put("tnewsContent",tnewsContent);
            mapList.add(map);
        }
       return mapList;
    }

    /**
     * 根据新闻id获取详细信息
     * @param id 新闻实体id
     * @return
     */
    @RequestMapping("/getDetailById")
    public ResultMsg getDetailById(String id){
        if(StringUtil.isNotEmpty(id)){
            Tnews tnews = tnewsService.findOne(id);
            TnewsContent tnewsContent =tnewsContentService.find(Filter.eq("newsId",id));
            List<TnewsAttachment> attachments=tnewsAttachmentService.findList(Filter.eq("newsId",id));
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tnews",tnews);
            map.put("tnewsContent",tnewsContent);
            map.put("attachments",attachments);
            return ResultMsg.sussess("数据获取成功", ListUtil.oneToList(map));
        }
         return ResultMsg.fault("参数为空，获取数据失败");
    }


    /**
     * 获取班级介绍
     * @param classId
     * @return
     */
    @RequestMapping("/getClassIntroduce")
    public ResultMsg getClassIntroduce(String classId){
        if(StringUtil.isNotEmpty(classId)){
           EduClass eduClass=eduClassService.findOne(classId);
           return ResultMsg.sussess("数据获取成功",ListUtil.oneToList(eduClass));
        }else{
            return ResultMsg.fault("参数为空");
        }
    }
}
