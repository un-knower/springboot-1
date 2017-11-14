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
@Table(name = "t_attendance_record")
public class TattendanceRecord implements Serializable{

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
		
	@Column(name = "CLASS_ID")
	private String classId;
	
	@Column(name = "GRADE_ID")
	private String gradeId;
		
	@Column(name = "STUDENT_ID")
	private String studentId;
		
	@Column(name = "COME_FIRST")
	private Date comeFirst;
		
	@Column(name = "GO_FIRST")
	private Date goFirst;
		
	@Column(name = "COME_SECOND")
	private Date comeSecond;
		
	@Column(name = "GO_SECOND")
	private Date goSecond;
		
	@Column(name = "FIRST_RESULT")
	private String firstResult;
		
	@Column(name = "SECOND_RESULT")
	private String secondResult;
		
	@Column(name = "ATTENDACE_DATE")
	private Date attendaceDate;
	
	@Column(name = "third_result")
	private String thirdResult;
		
	@Column(name = "fourth_result")
	private String fourthResult;
		
	
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
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	
	
	public Date getComeFirst() {
		return comeFirst;
	}

	public void setComeFirst(Date comeFirst) {
		this.comeFirst = comeFirst;
	}	
	
	public Date getGoFirst() {
		return goFirst;
	}

	public void setGoFirst(Date goFirst) {
		this.goFirst = goFirst;
	}	
	
	public Date getComeSecond() {
		return comeSecond;
	}

	public void setComeSecond(Date comeSecond) {
		this.comeSecond = comeSecond;
	}	
	
	public Date getGoSecond() {
		return goSecond;
	}

	public void setGoSecond(Date goSecond) {
		this.goSecond = goSecond;
	}	
	
	public String getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(String firstResult) {
		this.firstResult = firstResult;
	}	
	
	public String getSecondResult() {
		return secondResult;
	}

	public void setSecondResult(String secondResult) {
		this.secondResult = secondResult;
	}	
	
	public Date getAttendaceDate() {
		return attendaceDate;
	}

	public void setAttendaceDate(Date attendaceDate) {
		this.attendaceDate = attendaceDate;
	}

	public String getThirdResult() {
		return thirdResult;
	}

	public void setThirdResult(String thirdResult) {
		this.thirdResult = thirdResult;
	}

	public String getFourthResult() {
		return fourthResult;
	}

	public void setFourthResult(String fourthResult) {
		this.fourthResult = fourthResult;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	


	
}  
