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
 * 创建时间：2017-06-16
 * @version
 */
@Entity
@Table(name = "edu_class")
public class EduClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* id
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;	
	/**
	* className
	*/
	@Column(name = "CLASS_NAME")
	private String className;

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name="introduce")
	private String introduce;
	/**
	* classCode
	*/
	@Column(name = "CLASS_CODE")
	private String classCode;	
	/**
	* gradeId
	*/
	@Column(name = "GRADE_ID")
	private String gradeId;	
	/**
	* schoolId
	*/
	@Column(name = "SCHOOL_ID")
	private String schoolId;	
	/**
	* delFlag
	*/
	@Column(name = "DEL_FLAG")
	private String delFlag;	
	/**
	* createUser
	*/
	@Column(name = "CREATE_USER")
	private String createUser;	
	/**
	* createTime
	*/
	@Column(name = "CREATE_TIME")
	private Date createTime;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}	
	
	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	
	
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}	
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	


	
}  
