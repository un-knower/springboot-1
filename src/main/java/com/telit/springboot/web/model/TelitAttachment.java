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
@Table(name = "telit_attachment")
public class TelitAttachment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
		
	@Column(name = "FILE_NAME")
	private String fileName;
		
	@Column(name = "FILE_SIZE")
	private Integer fileSize;
		
	@Column(name = "FILE_TYPE")
	private String fileType;
		
	@Column(name = "ATTACHMENT_TYPE")
	private String attachmentType;
		
	@Column(name = "DATA_ID")
	private Integer dataId;
		
	@Column(name = "FILE_CODE")
	private String fileCode;
		
	@Column(name = "DESCN")
	private String descn;
		
	@Column(name = "DEL_FLAG")
	private Integer delFlag;
		
	@Column(name = "CREATE_TIME")
	private Date createTime;
		
	@Column(name = "CREATE_USER")
	private String createUser;
		
	@Column(name = "UPDATE_TIME")
	private Date updateTime;
		
	@Column(name = "UPDATE_USER")
	private String updateUser;
		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	
	
	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}	
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}	
	
	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}	
	
	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}	
	
	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}	
	
	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
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


	
}  
