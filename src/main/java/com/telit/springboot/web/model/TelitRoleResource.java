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
@Table(name = "telit_role_resource")
public class TelitRoleResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer roleId;
		
	@Column(name = "RESOURCE_ID")
	private Integer resourceId;
		
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}	
	
	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}	


	
}  
