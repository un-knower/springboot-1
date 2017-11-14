package com.telit.springboot.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 说明： model
 * 创建人：fwn
 * 创建时间：2017-06-15
 * @version
 */
@Entity
@Table(name = "edu_section")
public class EduSection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	@Column(name = "WEEKLY")
	private String weekly;
		
	@Column(name = "SECTION")
	private String section;
		
	@Column(name = "NAME")
	private String name;
		
	@Column(name = "START_TIME")
	private String startTime;
		
	@Column(name = "END_TIME")
	private String endTime;
		
	@Column(name = "FIX_ID")
	private String fixId;
		
	@Column(name = "MORNING")
	private String morning;
		
	@Column(name = "AFTERNOON")
	private String afternoon;
		
	@Column(name = "NIGHT")
	private String night;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	
	
	public String getWeekly() {
		return weekly;
	}

	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}	
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}	
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}	
	
	public String getFixId() {
		return fixId;
	}

	public void setFixId(String fixId) {
		this.fixId = fixId;
	}	
	
	public String getMorning() {
		return morning;
	}

	public void setMorning(String morning) {
		this.morning = morning;
	}	
	
	public String getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}	
	
	public String getNight() {
		return night;
	}

	public void setNight(String night) {
		this.night = night;
	}	


	
}  
