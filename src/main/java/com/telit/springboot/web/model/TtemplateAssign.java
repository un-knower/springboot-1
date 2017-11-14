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
@Table(name = "t_template_assign")
public class TtemplateAssign implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	@Column(name = "GRADE_ID")
	private String gradeId;
		
	@Column(name = "CLASS_ID")
	private String classId;
		
	@Column(name = "TEMPLATE_ID")
	private String templateId;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}	
	
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}	
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}	
	
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}	


	
}  
