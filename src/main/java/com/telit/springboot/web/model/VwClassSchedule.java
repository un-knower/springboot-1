package com.telit.springboot.web.model;



import javax.persistence.*;

/** 
 * 说明： model
 * 创建人：hjl
 * 
 * 创建时间：2017-06-16
 * @version
 */
@Entity
@Table(name = "vw_class_schedule")
public class VwClassSchedule {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	/**
	* schoolYear
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String id;		
	/**
	* schoolYear
	*/
	@Column(name = "school_year")
	private String schoolYear;	
	/**
	* semesterName
	*/
	@Column(name = "semester_name")
	private String semesterName;	
	/**
	* classId
	*/
	@Column(name = "class_id")
	private String classId;	
	/**
	* className
	*/
	@Column(name = "class_name")
	private String className;	
	/**
	* weekly
	*/
	@Column(name = "weekly")
	private String weekly;	
	/**
	* section
	*/
	@Column(name = "section")
	private String section;	
	/**
	* positionId
	*/
	@Column(name = "position_id")
	private String positionId;	
	/**
	* name
	*/
	@Column(name = "name")
	private String name;
	
	/**
	* positionName
	*/
	@Column(name = "position_name")
	private String positionName;
	
	/**
	* subjectName
	*/
	@Column(name = "subject_name")
	private String subjectName;
	
	/**
	* teacherId
	*/
	@Column(name = "teacher_id")
	private String teacherId;
	
	/**
	* teacherName
	*/
	@Column(name = "teacher_name")
	private String teacherName;
	
	/**
	* teacherPhoto
	*/
	@Column(name = "teacher_photo")
	private String teacherPhoto;
	
	/**
	* teacherJs
	*/
	@Transient
	private String teacherJs;

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getWeekly() {
		return weekly;
	}

	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPhoto() {
		return teacherPhoto;
	}

	public void setTeacherPhoto(String teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
	}

	public String getTeacherJs() {
		return teacherJs;
	}

	public void setTeacherJs(String teacherJs) {
		this.teacherJs = teacherJs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "VwClassSchedule{" +
				"id='" + id + '\'' +
				", schoolYear='" + schoolYear + '\'' +
				", semesterName='" + semesterName + '\'' +
				", classId='" + classId + '\'' +
				", className='" + className + '\'' +
				", weekly='" + weekly + '\'' +
				", section='" + section + '\'' +
				", positionId='" + positionId + '\'' +
				", name='" + name + '\'' +
				", positionName='" + positionName + '\'' +
				", subjectName='" + subjectName + '\'' +
				", teacherId='" + teacherId + '\'' +
				", teacherName='" + teacherName + '\'' +
				", teacherPhoto='" + teacherPhoto + '\'' +
				", teacherJs='" + teacherJs + '\'' +
				'}';
	}
}
