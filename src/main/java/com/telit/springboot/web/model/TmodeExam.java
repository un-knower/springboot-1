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
@Table(name = "t_mode_exam")
public class TmodeExam implements Serializable{

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
		
	@Column(name = "RULE")
	private String rule;
	
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
		
	@Column(name = "SUBJECT")
	private String subject;
		
	@Column(name = "BEGIN_POINT")
	private String beginPoint;
		
	@Column(name = "END_POINT")
	private String endPoint;
	
	@Column(name = "BEGIN_NUMBER")
	private String beginNumber;
	
	@Column(name = "END_NUMBER")
	private String endNumber;
	
	@Column(name = "ROOM_NUMBER")
	private String roomNumber;
		
	@Column(name = "TEACHER_NAME1")
	private String teacherName1;
	
	@Column(name = "TEACHER_HEAD1")
	private String teacherHead1;
	
	@Column(name = "TEACHER_NAME2")
	private String teacherName2;
	
	@Column(name = "TEACHER_HEAD2")
	private String teacherHead2;
	
	@Column(name = "TEACHER_NAME3")
	private String teacherName3;
	
	@Column(name = "TEACHER_HEAD3")
	private String teacherHead3;
	
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
	
	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
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
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	
	
	public String getBeginPoint() {
		return beginPoint;
	}

	public void setBeginPoint(String beginPoint) {
		this.beginPoint = beginPoint;
	}	
	
	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getBeginNumber() {
		return beginNumber;
	}

	public void setBeginNumber(String beginNumber) {
		this.beginNumber = beginNumber;
	}

	public String getEndNumber() {
		return endNumber;
	}

	public void setEndNumber(String endNumber) {
		this.endNumber = endNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getTeacherName1() {
		return teacherName1;
	}

	public void setTeacherName1(String teacherName1) {
		this.teacherName1 = teacherName1;
	}

	public String getTeacherHead1() {
		return teacherHead1;
	}

	public void setTeacherHead1(String teacherHead1) {
		this.teacherHead1 = teacherHead1;
	}

	public String getTeacherName2() {
		return teacherName2;
	}

	public void setTeacherName2(String teacherName2) {
		this.teacherName2 = teacherName2;
	}

	public String getTeacherHead2() {
		return teacherHead2;
	}

	public void setTeacherHead2(String teacherHead2) {
		this.teacherHead2 = teacherHead2;
	}

	public String getTeacherName3() {
		return teacherName3;
	}

	public void setTeacherName3(String teacherName3) {
		this.teacherName3 = teacherName3;
	}

	public String getTeacherHead3() {
		return teacherHead3;
	}

	public void setTeacherHead3(String teacherHead3) {
		this.teacherHead3 = teacherHead3;
	}	

	
	
}  
