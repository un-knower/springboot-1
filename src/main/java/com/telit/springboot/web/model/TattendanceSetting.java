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
 * 创建时间：2017-07-06
 * @version
 */
@Entity
@Table(name = "t_attendance_setting")
public class TattendanceSetting implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "COME_F_BEGIN")
	private String comeFBegin;
		
	@Column(name = "COME_F")
	private String comeF;
		
	@Column(name = "COME_F_END")
	private String comeFEnd;
		
	@Column(name = "GO_F_BEGIN")
	private String goFBegin;
		
	@Column(name = "GO_F")
	private String goF;
		
	@Column(name = "GO_F_END")
	private String goFEnd;
		
	@Column(name = "COME_S_BEGIN")
	private String comeSBegin;
		
	@Column(name = "COME_S")
	private String comeS;
		
	@Column(name = "COME_S_END")
	private String comeSEnd;
		
	@Column(name = "GO_S_BEGIN")
	private String goSBegin;
		
	@Column(name = "GO_S")
	private String goS;
		
	@Column(name = "GO_S_END")
	private String goSEnd;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getComeFBegin() {
		return comeFBegin;
	}

	public void setComeFBegin(String comeFBegin) {
		this.comeFBegin = comeFBegin;
	}	
	
	public String getComeF() {
		return comeF;
	}

	public void setComeF(String comeF) {
		this.comeF = comeF;
	}	
	
	public String getComeFEnd() {
		return comeFEnd;
	}

	public void setComeFEnd(String comeFEnd) {
		this.comeFEnd = comeFEnd;
	}	
	
	public String getGoFBegin() {
		return goFBegin;
	}

	public void setGoFBegin(String goFBegin) {
		this.goFBegin = goFBegin;
	}	
	
	public String getGoF() {
		return goF;
	}

	public void setGoF(String goF) {
		this.goF = goF;
	}	
	
	public String getGoFEnd() {
		return goFEnd;
	}

	public void setGoFEnd(String goFEnd) {
		this.goFEnd = goFEnd;
	}	
	
	public String getComeSBegin() {
		return comeSBegin;
	}

	public void setComeSBegin(String comeSBegin) {
		this.comeSBegin = comeSBegin;
	}	
	
	public String getComeS() {
		return comeS;
	}

	public void setComeS(String comeS) {
		this.comeS = comeS;
	}	
	
	public String getComeSEnd() {
		return comeSEnd;
	}

	public void setComeSEnd(String comeSEnd) {
		this.comeSEnd = comeSEnd;
	}	
	
	public String getGoSBegin() {
		return goSBegin;
	}

	public void setGoSBegin(String goSBegin) {
		this.goSBegin = goSBegin;
	}	
	
	public String getGoS() {
		return goS;
	}

	public void setGoS(String goS) {
		this.goS = goS;
	}	
	
	public String getGoSEnd() {
		return goSEnd;
	}

	public void setGoSEnd(String goSEnd) {
		this.goSEnd = goSEnd;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	


	
}  
