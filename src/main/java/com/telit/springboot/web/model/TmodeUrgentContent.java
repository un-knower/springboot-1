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
 * 创建时间：2017-07-03
 * @version
 */
@Entity
@Table(name = "t_mode_urgent_content")
public class TmodeUrgentContent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "URGEN_ID")
	private String urgenId;
		
	@Column(name = "URGENT_CONTENT")
	private String urgentContent;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getUrgenId() {
		return urgenId;
	}

	public void setUrgenId(String urgenId) {
		this.urgenId = urgenId;
	}	
	
	public String getUrgentContent() {
		return urgentContent;
	}

	public void setUrgentContent(String urgentContent) {
		this.urgentContent = urgentContent;
	}	


	
}  
