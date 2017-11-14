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
@Table(name = "t_questionnaire_question_select")
public class TquestionnaireQuestionSelect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "QUESTION_ID")
	private String questionId;
		
	@Column(name = "SELECT_CONTENT")
	private String selectContent;
		
	@Column(name = "SELECT_INDEX")
	private Integer selectIndex;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}	
	
	public String getSelectContent() {
		return selectContent;
	}

	public void setSelectContent(String selectContent) {
		this.selectContent = selectContent;
	}	
	
	public Integer getSelectIndex() {
		return selectIndex;
	}

	public void setSelectIndex(Integer selectIndex) {
		this.selectIndex = selectIndex;
	}	


	
}  
