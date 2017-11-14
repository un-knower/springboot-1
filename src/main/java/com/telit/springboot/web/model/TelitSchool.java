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
@Table(name = "telit_school")
public class TelitSchool implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;
		
	@Column(name = "AREA_ID")
	private String areaId;
		
	@Column(name = "SCHOOL_NAME")
	private String schoolName;
		
	@Column(name = "SCHOOL_CODE")
	private String schoolCode;
		
	@Column(name = "SCHOOL_ENAME")
	private String schoolEname;
		
	@Column(name = "SCHOOL_TEL1")
	private String schoolTel1;
		
	@Column(name = "SCHOOL_TEL2")
	private String schoolTel2;
		
	@Column(name = "NATURE")
	private String nature;
		
	@Column(name = "ZIP_CODE")
	private String zipCode;
		
	@Column(name = "ELECTRONIC_FAX")
	private String electronicFax;
		
	@Column(name = "EMAIL")
	private String email;
		
	@Column(name = "SCHOOL_SYSTEM")
	private String schoolSystem;
		
	@Column(name = "SCHOOL_ADDR")
	private String schoolAddr;
		
	@Column(name = "ADMIN_USER")
	private String adminUser;
		
	@Column(name = "LEGAL_REPRESENTATIVE")
	private String legalRepresentative;
		
	@Column(name = "SCHOOL_TYPE")
	private String schoolType;
		
	@Column(name = "LONGITUDE")
	private String longitude;
		
	@Column(name = "LATITUDE")
	private String latitude;
		
	@Column(name = "SIGN_IN")
	private String signIn;
		
	@Column(name = "CREATE_USER")
	private String createUser;
		
	@Column(name = "CREATE_TIME")
	private String createTime;
		
	@Column(name = "UPDATE_USER")
	private String updateUser;
		
	@Column(name = "UPDATE_TIME")
	private String updateTime;
		
	@Column(name = "REMARK")
	private String remark;
		
	@Column(name = "DEL_FLAG")
	private String delFlag;
		
	@Column(name = "RADIUS")
	private String radius;
		
	@Column(name = "MORNING_SIGN_STARTTIME")
	private String morningSignStarttime;
		
	@Column(name = "MORNING_SIGN_ENDTIME")
	private String morningSignEndtime;
		
	@Column(name = "NIGHT_SIGN_STARTTIME")
	private String nightSignStarttime;
		
	@Column(name = "NIGHT_SIGN_ENDTIME")
	private String nightSignEndtime;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}	
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}	
	
	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}	
	
	public String getSchoolEname() {
		return schoolEname;
	}

	public void setSchoolEname(String schoolEname) {
		this.schoolEname = schoolEname;
	}	
	
	public String getSchoolTel1() {
		return schoolTel1;
	}

	public void setSchoolTel1(String schoolTel1) {
		this.schoolTel1 = schoolTel1;
	}	
	
	public String getSchoolTel2() {
		return schoolTel2;
	}

	public void setSchoolTel2(String schoolTel2) {
		this.schoolTel2 = schoolTel2;
	}	
	
	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}	
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	
	
	public String getElectronicFax() {
		return electronicFax;
	}

	public void setElectronicFax(String electronicFax) {
		this.electronicFax = electronicFax;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getSchoolSystem() {
		return schoolSystem;
	}

	public void setSchoolSystem(String schoolSystem) {
		this.schoolSystem = schoolSystem;
	}	
	
	public String getSchoolAddr() {
		return schoolAddr;
	}

	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}	
	
	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}	
	
	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}	
	
	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}	
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}	
	
	public String getSignIn() {
		return signIn;
	}

	public void setSignIn(String signIn) {
		this.signIn = signIn;
	}	
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}	
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}	
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}	
	
	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}	
	
	public String getMorningSignStarttime() {
		return morningSignStarttime;
	}

	public void setMorningSignStarttime(String morningSignStarttime) {
		this.morningSignStarttime = morningSignStarttime;
	}	
	
	public String getMorningSignEndtime() {
		return morningSignEndtime;
	}

	public void setMorningSignEndtime(String morningSignEndtime) {
		this.morningSignEndtime = morningSignEndtime;
	}	
	
	public String getNightSignStarttime() {
		return nightSignStarttime;
	}

	public void setNightSignStarttime(String nightSignStarttime) {
		this.nightSignStarttime = nightSignStarttime;
	}	
	
	public String getNightSignEndtime() {
		return nightSignEndtime;
	}

	public void setNightSignEndtime(String nightSignEndtime) {
		this.nightSignEndtime = nightSignEndtime;
	}	


	
}  
