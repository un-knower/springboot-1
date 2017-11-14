package com.telit.springboot.web.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 说明： model
 * 创建人：hjl
 * 
 * 创建时间：2017-06-16
 * @version
 */
@Entity
@Table(name = "vw_school_class")
public class VwSchoolClass {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* areaId
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private String areaId;	
	/**
	* areaName
	*/
	@Column(name = "area_name")
	private String areaName;	
	/**
	* areaParentid
	*/
	@Column(name = "area_parentid")
	private String areaParentid;	
	/**
	* schoolId
	*/
	@Column(name = "school_id")
	private String schoolId;	
	/**
	* schoolName
	*/
	@Column(name = "school_name")
	private String schoolName;	
	/**
	* gradeId
	*/
	@Column(name = "grade_id")
	private String gradeId;
	
	
	/**
	* gradeName
	*/
	@Column(name = "grade_name")
	private String gradeName;
	
	/**
	* classId
	*/
	@Column(name = "class_id")
	private String classId;
	
	/**
	* className
	*/
	@Column(name = "class_name")
	private String className;

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaParentid() {
		return areaParentid;
	}

	public void setAreaParentid(String areaParentid) {
		this.areaParentid = areaParentid;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
	
	
	
	
	
	
}
