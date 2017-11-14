package com.telit.springboot.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 
 * 说明： model
 * 创建人：fwn
 * 创建时间：2017-07-05
 * @version
 */
@Entity
@Table(name = "t_onduty_detail_student")
public class TondutyDetailStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "ONDUTY_DETAIL_ID")
	private String ondutyDetailId;
		
	@Column(name = "TYPE")
	private Integer type;
		
	@Column(name = "STUDENT_ID")
	private String studentId;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getOndutyDetailId() {
		return ondutyDetailId;
	}

	public void setOndutyDetailId(String ondutyDetailId) {
		this.ondutyDetailId = ondutyDetailId;
	}	
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	


	
}  
