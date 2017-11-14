package com.telit.springboot.web.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="t_recipe")
public class RecipeModel implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;
    @Column
    private String weekly;//(1-5代表周一到周五)


    public String getSchoolId() {

        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Column
    private String schoolId;


    public String getWeekly() {

        return weekly;
    }

    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
