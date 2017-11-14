package com.telit.springboot.web.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_activity")
public class ActivityModel implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;
    @Column
    private String title;//活动主题

    @Lob
    @Basic(fetch=FetchType.EAGER)
    @Column
    private String content;//活动内容
    @Column
    private String place;//活动地点
    @Column
    private Date playStartDate;//活动开始时间
    @Column
    private Date playEndDate;//活动结束时间
    @Lob
    @Basic(fetch=FetchType.EAGER)
    @Column
    private String photo;//活动照片
    @Column
    private String classId;//班级id
    @Column
    private String schoolId;//学校id
    @Column
    private String creatUser;//创建人

    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser;
    }

    public String getSchoolId() {

        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getClassId() {

        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPlace() {

        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPlayEndDate() {

        return playEndDate;
    }

    public void setPlayEndDate(Date playEndDate) {
        this.playEndDate = playEndDate;
    }

    public Date getPlayStartDate() {

        return playStartDate;
    }

    public void setPlayStartDate(Date playStartDate) {
        this.playStartDate = playStartDate;
    }
}
