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
 * 创建时间：2017-06-23
 * @version
 */
@Entity
@Table(name = "t_device")
public class Tdevice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "DEVICE_NAME")
	private String deviceName;
		
	@Column(name = "PLATFORM")
	private String platform;
		
	@Column(name = "UUID")
	private String uuid;
		
	@Column(name = "SERIAL")
	private String serial;
		
	@Column(name = "CLASS_ID")
	private String classId;
		
	@Column(name = "IP")
	private String ip;
		
	@Column(name = "RUN_STATUS")
	private String runStatus;
		
	@Column(name = "RUN_MODE")
	private String runMode;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	@Column(name = "CLASS_LOGO")
	private String classLogo;
		
	@Column(name = "CLASS_KEYWORD")
	private String classKeyword;
	
	@Column(name = "CLASS_BANDER_URL")
	private String classBanderUrl;	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}	
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}	
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}	
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}	
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}	
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}	
	
	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}	
	
	public String getRunMode() {
		return runMode;
	}

	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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

	public String getClassBanderUrl() {
		return classBanderUrl;
	}

	public void setClassBanderUrl(String classBanderUrl) {
		this.classBanderUrl = classBanderUrl;
	}	


	
}  
