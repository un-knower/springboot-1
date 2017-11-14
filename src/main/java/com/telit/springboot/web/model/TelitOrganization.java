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
@Table(name = "telit_organization")
public class TelitOrganization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
		
	@Column(name = "LEVEL_")
	private Integer level;
		
	@Column(name = "NAME")
	private String name;
		
	@Column(name = "AREACODE")
	private String areacode;
		
	@Column(name = "ORGSEQ")
	private String orgseq;
		
	@Column(name = "PARENTID")
	private Integer parentid;
		
	@Column(name = "THESORT")
	private Integer thesort;
		
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
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}	
	
	public String getOrgseq() {
		return orgseq;
	}

	public void setOrgseq(String orgseq) {
		this.orgseq = orgseq;
	}	
	
	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}	
	
	public Integer getThesort() {
		return thesort;
	}

	public void setThesort(Integer thesort) {
		this.thesort = thesort;
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
