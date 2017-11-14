package com.telit.springboot.web.model;

import java.io.Serializable;
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
 * 创建时间：2017-07-26
 * @version
 */
@Entity
@Table(name = "telit_user")
public class TelitUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
								
	/**
	 * 用户管理表
	 */
    @Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
		
	/**
	 * 用户账号
	 */
	@Column(name = "USER_CODE")
	private String userCode;
		
	/**
	 * 用户姓名
	 */
	@Column(name = "USER_NAME")
	private String userName;
		
	/**
	 * 登陆密码
	 */
	@Column(name = "PASSWORD")
	private String password;
		
	/**
	 * 盐
	 */
	@Column(name = "SALT")
	private String salt;
		
	/**
	 * 区域id
	 */
	@Column(name = "AREA_ID")
	private Integer areaId;
		
	/**
	 * 机构id
	 */
	@Column(name = "ORG_ID")
	private Integer orgId;
		
	/**
	 * 出生年月日
	 */
	@Column(name = "BIRTHDAY")
	private String birthday;
		
	/**
	 * 性别(M 男 F 女)
	 */
	@Column(name = "GENDER")
	private String gender;
		
	/**
	 * 邮箱
	 */
	@Column(name = "EMAIL")
	private String email;
		
	/**
	 * 电话
	 */
	@Column(name = "PHONE_NO")
	private String phoneNo;
		
	/**
	 * 移动电话
	 */
	@Column(name = "MPHONE_NO")
	private String mphoneNo;
		
	/**
	 * 错误总数
	 */
	@Column(name = "ERROR_COUNT")
	private Integer errorCount;
		
	/**
	 * 最后一次登陆时间
	 */
	@Column(name = "LAST_LOGIN_TIME")
	private Date lastLoginTime;
		
	/**
	 * passwdInvalTime
	 */
	@Column(name = "PASSWD_INVAL_TIME")
	private Date passwdInvalTime;
		
	/**
	 * lockTime
	 */
	@Column(name = "LOCK_TIME")
	private Date lockTime;
		
	/**
	 * 删除标志
	 */
	@Column(name = "DEL_FLAG")
	private Integer delFlag;
		
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Date createTime;
		
	/**
	 * 创建人
	 */
	@Column(name = "CREATE_USER")
	private String createUser;
		
	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
		
	/**
	 * 修改人
	 */
	@Column(name = "UPDATE_USER")
	private String updateUser;
		
	/**
	 * 二维码
	 */
	@Column(name = "QRCODE")
	private String qrcode;
		
	/**
	 * 个性签名
	 */
	@Column(name = "SIGN")
	private String sign;
		
	/**
	 * position
	 */
	@Column(name = "POSITION")
	private String position;
		
	/**
	 * schoolId
	 */
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	/**
	 * 用户头像
	 */
	@Column(name = "PHOTO")
	private String photo;
		
	/**
	 * ischarge
	 */
	@Column(name = "ISCHARGE")
	private String ischarge;
		
	/**
	 * registrationId
	 */
	@Column(name = "REGISTRATION_ID")
	private String registrationId;
		
	/**
	 * sessionId
	 */
	@Column(name = "SESSION_ID")
	private String sessionId;
		
	/**
	 * 设备id
	 */
	@Column(name = "DEVICE_ID")
	private String deviceId;
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}	
	
	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}	
	
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}	
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}	
	
	public String getMphoneNo() {
		return mphoneNo;
	}

	public void setMphoneNo(String mphoneNo) {
		this.mphoneNo = mphoneNo;
	}	
	
	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}	
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}	
	
	public Date getPasswdInvalTime() {
		return passwdInvalTime;
	}

	public void setPasswdInvalTime(Date passwdInvalTime) {
		this.passwdInvalTime = passwdInvalTime;
	}	
	
	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}	
	
	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}	
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}	
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}	
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}	
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}	
	
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}	
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}	
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
	
	public String getIscharge() {
		return ischarge;
	}

	public void setIscharge(String ischarge) {
		this.ischarge = ischarge;
	}	
	
	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}	
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}	


	
}  
