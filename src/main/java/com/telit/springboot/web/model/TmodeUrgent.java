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
 * 创建时间：2017-06-28
 * @version
 */
@Entity
@Table(name = "t_mode_urgent")
public class TmodeUrgent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "MODE_NAME")
	private String modeName;
		
	@Column(name = "INDEX_NUM")
	private Integer indexNum;
	
	@Column(name = "school_id")
	private String schoolId;
		
	@Column(name = "CLASS_ID")
	private String classId;
		
	@Column(name = "RUN_FLAG")
	private String runFlag;
		
	@Column(name = "VALID_BEGIN")
	private Date validBegin;
		
	@Column(name = "VALID_END")
	private Date validEnd;
		
	@Column(name = "BG_MUSIC")
	private String bgMusic;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}	
	
	public Integer getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(Integer indexNum) {
		this.indexNum = indexNum;
	}	
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}	
	
	public String getRunFlag() {
		return runFlag;
	}

	public void setRunFlag(String runFlag) {
		this.runFlag = runFlag;
	}	
	
	public Date getValidBegin() {
		return validBegin;
	}

	public void setValidBegin(Date validBegin) {
		this.validBegin = validBegin;
	}	
	
	public Date getValidEnd() {
		return validEnd;
	}

	public void setValidEnd(Date validEnd) {
		this.validEnd = validEnd;
	}	
	
	public String getBgMusic() {
		return bgMusic;
	}

	public void setBgMusic(String bgMusic) {
		this.bgMusic = bgMusic;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	


	
}  
