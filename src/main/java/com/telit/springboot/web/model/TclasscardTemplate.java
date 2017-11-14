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
@Table(name = "t_classcard_template")
public class TclasscardTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "TEMPLATE_NAME")
	private String templateName;
		
	@Column(name = "TEMPLATE_THUMB")
	private String templateThumb;
		
	@Column(name = "TEMPLATE_URL")
	private String templateUrl;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}	
	
	public String getTemplateThumb() {
		return templateThumb;
	}

	public void setTemplateThumb(String templateThumb) {
		this.templateThumb = templateThumb;
	}	
	
	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}	


	
}  
