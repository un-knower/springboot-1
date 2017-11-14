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
@Table(name = "vw_school_brand_info")
public class VwSchoolBrandInfo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* id
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	* schoolId
	*/
	@Column(name = "school_id")
	private String schoolId;
	
	/**
	* classId
	*/
	@Column(name = "class_id")
	private String classId;
	
	/**
	* schoolName
	*/
	@Column(name = "school_name")
	private String schoolName;
	
	/**
	* deviceId
	*/
	@Column(name = "device_id")
	private String deviceId;
	
	/**
	* deviceSerial
	*/
	@Column(name = "device_serial")
	private String deviceSerial;
	
	/**
	* deviceName
	*/
	@Column(name = "device_name")
	private String deviceName;
	
	/**
	* schoolLogo
	*/
	@Column(name = "school_logo")
	private String schoolLogo;
	
	/**
	* schoolKeyword
	*/
	@Column(name = "school_keyword")
	private String schoolKeyword;

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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceSerial() {
		return deviceSerial;
	}

	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getSchoolLogo() {
		return schoolLogo;
	}

	public void setSchoolLogo(String schoolLogo) {
		this.schoolLogo = schoolLogo;
	}

	public String getSchoolKeyword() {
		return schoolKeyword;
	}

	public void setSchoolKeyword(String schoolKeyword) {
		this.schoolKeyword = schoolKeyword;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	
	
	
	
	
	
	
}
