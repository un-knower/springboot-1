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
@Table(name = "t_news")
public class Tnews implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "NEWS_TITLE")
	private String newsTitle;
	
	@Column(name = "THEME_IMG")
	private String themeImg;
	
	@Column(name = "BG_MUSIC")
	private String bgMusic;
		
	@Column(name = "NEWS_TYPE")
	private String newsType;
		
	@Column(name = "CLASS_ID")
	private String classId;
		
	@Column(name = "PUBLISHER")
	private String publisher;
		
	@Column(name = "PUBLISH_TIME")
	private Date publishTime;
		
	@Column(name = "NEWS_LEVEL")
	private Integer newsLevel;
	
	@Column(name = "SCHOOL_ID")
	private String schoolId;
	
	@Column(name = "FlAG")
	private Integer flag;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}	
	
	public String getBgMusic() {
		return bgMusic;
	}

	public void setBgMusic(String bgMusic) {
		this.bgMusic = bgMusic;
	}	
	
	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}	
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}	
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
	
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}	
	
	public Integer getNewsLevel() {
		return newsLevel;
	}

	public void setNewsLevel(Integer newsLevel) {
		this.newsLevel = newsLevel;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getThemeImg() {
		return themeImg;
	}

	public void setThemeImg(String themeImg) {
		this.themeImg = themeImg;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	

	
}  
