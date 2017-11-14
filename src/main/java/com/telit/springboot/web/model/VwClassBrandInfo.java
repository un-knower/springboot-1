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
@Table(name = "vw_class_brand_info")
public class VwClassBrandInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* id
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private String classId;	
	/**
	* className
	*/
	@Column(name = "class_name")
	private String className;	
	/**
	* deviceName
	*/
	@Column(name = "device_name")
	private String deviceName;	
	/**
	* classLogo
	*/
	@Column(name = "class_logo")
	private String classLogo;	
	/**
	* class_keyword
	*/
	@Column(name = "class_keyword")
	private String classKeyword;	
	/**
	* bzrId
	*/
	@Column(name = "bzr_id")
	private String bzrId;	
	/**
	* bzrName
	*/
	@Column(name = "bzr_name")
	private String bzrName;	
	/**
	* bzrPhoto
	*/
	@Column(name = "bzr_photo")
	private String bzrPhoto;
	/**
	* schoolName
	*/
	@Column(name = "school_name")
	private String schoolName;
	/**
	* gradeName
	*/
	@Column(name = "grade_name")
	private String gradeName;
	/**
	* schoolId
	*/
	@Column(name = "school_id")
	private String schoolId;
	
	/**
	* bjzrs
	*/
	@Column(name = "bjzrs")
	private String bjzrs;

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

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getClassLogo() {
		return classLogo;
	}

	public void setClassLogo(String classLogo) {
		this.classLogo = classLogo;
	}

	public String getClassKeyword() {
		return classKeyword;
	}

	public void setClassKeyword(String classKeyword) {
		this.classKeyword = classKeyword;
	}

	public String getBzrId() {
		return bzrId;
	}

	public void setBzrId(String bzrId) {
		this.bzrId = bzrId;
	}

	public String getBzrName() {
		return bzrName;
	}

	public void setBzrName(String bzrName) {
		this.bzrName = bzrName;
	}

	public String getBzrPhoto() {
		return bzrPhoto;
	}

	public void setBzrPhoto(String bzrPhoto) {
		this.bzrPhoto = bzrPhoto;
	}

	public String getBjzrs() {
		return bjzrs;
	}

	public void setBjzrs(String bjzrs) {
		this.bjzrs = bjzrs;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	
	
	
}
