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
 * 创建时间：2017-06-22
 * @version
 */
@Entity
@Table(name = "t_news_type")
public class TnewsType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "NEWS_TYPE_NAME")
	private String newsTypeName;
		
	@Column(name = "CONTENT_TYPE")
	private String contentType;
		
	@Column(name = "ATTACHMENT_TYPES")
	private String attachmentTypes;
		
	@Column(name = "FLAG")
	private Integer flag;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getNewsTypeName() {
		return newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}	
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}	
	
	public String getAttachmentTypes() {
		return attachmentTypes;
	}

	public void setAttachmentTypes(String attachmentTypes) {
		this.attachmentTypes = attachmentTypes;
	}	
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	


	
}  
