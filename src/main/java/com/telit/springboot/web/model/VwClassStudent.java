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
@Table(name = "vw_class_student")
public class VwClassStudent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* userName
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_name")
	private String userName;	
	/**
	* photo
	*/
	@Column(name = "photo")
	private String photo;	
	/**
	* class_id
	*/
	@Column(name = "class_id")
	private String classId;	
	/**
	* sex
	*/
	@Column(name = "sex")
	private String sex;	
	/**
	* idNumber
	*/
	@Column(name = "id_number")
	private String idNumber;	
	/**
	* userId
	*/
	@Column(name = "user_id")
	private String userId;
	
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
	
	
	
}
