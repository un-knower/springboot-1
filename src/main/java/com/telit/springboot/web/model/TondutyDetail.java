package com.telit.springboot.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * 说明： model
 * 创建人：fwn
 * 创建时间：2017-07-06
 * @version
 */
@Entity
@Table(name = "t_onduty_detail")
public class TondutyDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "DUTY_ID")
	private String dutyId;
		
	@Column(name = "STUDENT_ID")
	private String studentId;
		
	@Column(name = "DUTY_DAY")
	private String dutyDay;
		
	@Column(name = "AREA")
	private String area;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	
	
	public String getDutyDay() {
		return dutyDay;
	}

	public void setDutyDay(String dutyDay) {
		this.dutyDay = dutyDay;
	}	
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}	


	
}  
