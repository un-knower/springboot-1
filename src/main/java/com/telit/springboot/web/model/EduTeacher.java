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

import org.hibernate.annotations.GenericGenerator;

/** 
 * 说明： model
 * 创建人：fwn
 * 创建时间：2017-06-15
 * @version
 */
@Entity
@Table(name = "edu_teacher")
public class EduTeacher implements Serializable{

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
		
	@Column(name = "USER_ID")
	private String userId;
		
	@Column(name = "NAME")
	private String name;
		
	@Column(name = "HEAD_PORTRAIT")
	private String headPortrait;
		
	@Column(name = "PHONE")
	private String phone;
		
	@Column(name = "WORK_NUMBER")
	private String workNumber;
		
	@Column(name = "ISJOB")
	private String isjob;
		
	@Column(name = "SEX")
	private String sex;
		
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
		
	@Column(name = "NATIONALITY")
	private String nationality;
		
	@Column(name = "CITIZENSHIP")
	private String citizenship;
		
	@Column(name = "POLITICS_STATUS")
	private String politicsStatus;
		
	@Column(name = "CLASSROOM_TUTORIAL")
	private String classroomTutorial;
		
	@Column(name = "TEACHERS_QSUBJECT")
	private String teachersQsubject;
		
	@Column(name = "ID_CARD_TYPE")
	private String idCardType;
		
	@Column(name = "ID_CARD_NUM")
	private String idCardNum;
		
	@Column(name = "EDUCATION_IDNUM")
	private String educationIdnum;
		
	@Column(name = "CEDUCATION_IDNUM")
	private String ceducationIdnum;
		
	@Column(name = "HIGHEST_SCHOOLING")
	private String highestSchooling;
		
	@Column(name = "EMAIL")
	private String email;
		
	@Column(name = "HOME_ZIPCODE")
	private String homeZipcode;
		
	@Column(name = "FORMER_NAME")
	private String formerName;
		
	@Column(name = "HIGHEST_PROFESSIONAL")
	private String highestProfessional;
		
	@Column(name = "DEGREE_TYPE")
	private String degreeType;
		
	@Column(name = "DEGREE_AMOUNT")
	private String degreeAmount;
		
	@Column(name = "HIGHEST_TIME")
	private Date highestTime;
		
	@Column(name = "FOREIGN_LANGUAGES")
	private String foreignLanguages;
		
	@Column(name = "LANGUAGE_LEVEL")
	private String languageLevel;
		
	@Column(name = "PRIMARY_EDUCATION")
	private String primaryEducation;
		
	@Column(name = "PRIMARY_PROFESSIONAL")
	private String primaryProfessional;
		
	@Column(name = "PRIMARY_EDUCTIONALSYSTME")
	private String primaryEductionalsystme;
		
	@Column(name = "PRIMARY_GRADUATESCHOOL")
	private String primaryGraduateschool;
		
	@Column(name = "PRIMARY_GRADUATIONTIME")
	private Date primaryGraduationtime;
		
	@Column(name = "OVERSEAS_CHINESE")
	private String overseasChinese;
		
	@Column(name = "OFFICE_PHONE")
	private String officePhone;
		
	@Column(name = "RESIDENTIAL_PHONE")
	private String residentialPhone;
		
	@Column(name = "REAL_ROLELEVEL")
	private String realRolelevel;
		
	@Column(name = "WAGE_JOBS")
	private String wageJobs;
		
	@Column(name = "PROFESSIONAL_TYPE")
	private String professionalType;
		
	@Column(name = "REVIEW_JOBTIME")
	private Date reviewJobtime;
		
	@Column(name = "REVIEW_DETAILED")
	private String reviewDetailed;
		
	@Column(name = "FULLTIME_TEACHER")
	private String fulltimeTeacher;
		
	@Column(name = "BACKBONE_TEACHERLEVEL")
	private String backboneTeacherlevel;
		
	@Column(name = "BACKBONE_TIME")
	private Date backboneTime;
		
	@Column(name = "CLASS_TEACHER")
	private String classTeacher;
		
	@Column(name = "CLASS_TEACHERTIME")
	private String classTeachertime;
		
	@Column(name = "CAMPUS")
	private String campus;
		
	@Column(name = "IDENTITIES")
	private String identities;
		
	@Column(name = "COME_MYSCHOOLTIME")
	private Date comeMyschooltime;
		
	@Column(name = "SCHOOL_AGE")
	private String schoolAge;
		
	@Column(name = "PARTICIPATE_EDUCATIONTIME")
	private Date participateEducationtime;
		
	@Column(name = "SENIORITY")
	private String seniority;
		
	@Column(name = "CONTINUOUS_LENGTHSERVICE")
	private String continuousLengthservice;
		
	@Column(name = "EMPLOYMENT_INITIALTIME")
	private Date employmentInitialtime;
		
	@Column(name = "EMPLOYMENT_FIXEDYEAR")
	private String employmentFixedyear;
		
	@Column(name = "EMPLOYMENT_ENDTIME")
	private Date employmentEndtime;
		
	@Column(name = "HOME_ADDR")
	private String homeAddr;
		
	@Column(name = "TECHNICAL_TITLE")
	private String technicalTitle;
		
	@Column(name = "TECHNICAL_TITLETIME")
	private Date technicalTitletime;
		
	@Column(name = "LOWLEVEL_REVIEWTIME")
	private Date lowlevelReviewtime;
		
	@Column(name = "REPRESENTATIVE")
	private String representative;
		
	@Column(name = "RELATIVES_ARMY")
	private String relativesArmy;
		
	@Column(name = "TEACHERS_QCNUM")
	private String teachersQcnum;
		
	@Column(name = "ORAL_ENGLISHLEVEL")
	private String oralEnglishlevel;
		
	@Column(name = "ORAL_ENGLISHTIME")
	private Date oralEnglishtime;
		
	@Column(name = "ORAL_ENGLISHLEVELNUM")
	private String oralEnglishlevelnum;
		
	@Column(name = "COMPUTER_LEVEL")
	private String computerLevel;
		
	@Column(name = "COMPUTER_LEVELTIME")
	private Date computerLeveltime;
		
	@Column(name = "COMPUTER_LEVELNUM")
	private String computerLevelnum;
		
	@Column(name = "MANDARIN_LEVEL")
	private String mandarinLevel;
		
	@Column(name = "PUTONGHUA_GRADETIME")
	private Date putonghuaGradetime;
		
	@Column(name = "PUTONGHUA_GRADENUM")
	private String putonghuaGradenum;
		
	@Column(name = "REMARK")
	private String remark;
		
	@Column(name = "DEPARTMENT_ID")
	private String departmentId;
		
	@Column(name = "PART_DEPARTMENTID")
	private String partDepartmentid;
		
	@Column(name = "HIGHEST_RECORD")
	private String highestRecord;
		
	@Column(name = "HIGHEST_RECORDSCHOOL")
	private String highestRecordschool;
		
	@Column(name = "HIGHEST_DEGREE")
	private String highestDegree;
		
	@Column(name = "HIGHEST_DEGREESCHOOL")
	private String highestDegreeschool;
		
	@Column(name = "HAVE_JOB")
	private Date haveJob;
		
	@Column(name = "JOB_TYPE")
	private String jobType;
		
	@Column(name = "JOB_GRADE")
	private String jobGrade;
		
	@Column(name = "ADMINISTRATIVE_DUTIES")
	private String administrativeDuties;
		
	@Column(name = "ITEM_ATHAND")
	private String itemAthand;
		
	@Column(name = "CONTRACT")
	private String contract;
		
	@Column(name = "MONTHLY_WAGES")
	private String monthlyWages;
		
	@Column(name = "INSURANCE")
	private String insurance;
		
	@Column(name = "TEACHER_CERTIFICATIONTYPE")
	private String teacherCertificationtype;
		
	@Column(name = "DATE_FROMTEACHING")
	private Date dateFromteaching;
		
	@Column(name = "CLASSROOM_LEARNINGPERIOD")
	private String classroomLearningperiod;
		
	@Column(name = "PROFESSIONAL_TECHNICAL")
	private String professionalTechnical;
		
	@Column(name = "FULLTIME")
	private String fulltime;
		
	@Column(name = "THREE_TEACHERSTRAINING")
	private String threeTeacherstraining;
		
	@Column(name = "FREE_NORMAL")
	private String freeNormal;
		
	@Column(name = "SPECIALPOST_TEACHER")
	private String specialpostTeacher;
		
	@Column(name = "PROFESSIONAL_TECHNOLOGY")
	private Date professionalTechnology;
		
	@Column(name = "TOGET_HIGHEST_RECORD")
	private Date togetHighestRecord;
		
	@Column(name = "PARTY")
	private Date party;
		
	
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
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
	
	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}	
	
	public String getIsjob() {
		return isjob;
	}

	public void setIsjob(String isjob) {
		this.isjob = isjob;
	}	
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}	
	
	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}	
	
	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}	
	
	public String getClassroomTutorial() {
		return classroomTutorial;
	}

	public void setClassroomTutorial(String classroomTutorial) {
		this.classroomTutorial = classroomTutorial;
	}	
	
	public String getTeachersQsubject() {
		return teachersQsubject;
	}

	public void setTeachersQsubject(String teachersQsubject) {
		this.teachersQsubject = teachersQsubject;
	}	
	
	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}	
	
	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}	
	
	public String getEducationIdnum() {
		return educationIdnum;
	}

	public void setEducationIdnum(String educationIdnum) {
		this.educationIdnum = educationIdnum;
	}	
	
	public String getCeducationIdnum() {
		return ceducationIdnum;
	}

	public void setCeducationIdnum(String ceducationIdnum) {
		this.ceducationIdnum = ceducationIdnum;
	}	
	
	public String getHighestSchooling() {
		return highestSchooling;
	}

	public void setHighestSchooling(String highestSchooling) {
		this.highestSchooling = highestSchooling;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getHomeZipcode() {
		return homeZipcode;
	}

	public void setHomeZipcode(String homeZipcode) {
		this.homeZipcode = homeZipcode;
	}	
	
	public String getFormerName() {
		return formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}	
	
	public String getHighestProfessional() {
		return highestProfessional;
	}

	public void setHighestProfessional(String highestProfessional) {
		this.highestProfessional = highestProfessional;
	}	
	
	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}	
	
	public String getDegreeAmount() {
		return degreeAmount;
	}

	public void setDegreeAmount(String degreeAmount) {
		this.degreeAmount = degreeAmount;
	}	
	
	public Date getHighestTime() {
		return highestTime;
	}

	public void setHighestTime(Date highestTime) {
		this.highestTime = highestTime;
	}	
	
	public String getForeignLanguages() {
		return foreignLanguages;
	}

	public void setForeignLanguages(String foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}	
	
	public String getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(String languageLevel) {
		this.languageLevel = languageLevel;
	}	
	
	public String getPrimaryEducation() {
		return primaryEducation;
	}

	public void setPrimaryEducation(String primaryEducation) {
		this.primaryEducation = primaryEducation;
	}	
	
	public String getPrimaryProfessional() {
		return primaryProfessional;
	}

	public void setPrimaryProfessional(String primaryProfessional) {
		this.primaryProfessional = primaryProfessional;
	}	
	
	public String getPrimaryEductionalsystme() {
		return primaryEductionalsystme;
	}

	public void setPrimaryEductionalsystme(String primaryEductionalsystme) {
		this.primaryEductionalsystme = primaryEductionalsystme;
	}	
	
	public String getPrimaryGraduateschool() {
		return primaryGraduateschool;
	}

	public void setPrimaryGraduateschool(String primaryGraduateschool) {
		this.primaryGraduateschool = primaryGraduateschool;
	}	
	
	public Date getPrimaryGraduationtime() {
		return primaryGraduationtime;
	}

	public void setPrimaryGraduationtime(Date primaryGraduationtime) {
		this.primaryGraduationtime = primaryGraduationtime;
	}	
	
	public String getOverseasChinese() {
		return overseasChinese;
	}

	public void setOverseasChinese(String overseasChinese) {
		this.overseasChinese = overseasChinese;
	}	
	
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}	
	
	public String getResidentialPhone() {
		return residentialPhone;
	}

	public void setResidentialPhone(String residentialPhone) {
		this.residentialPhone = residentialPhone;
	}	
	
	public String getRealRolelevel() {
		return realRolelevel;
	}

	public void setRealRolelevel(String realRolelevel) {
		this.realRolelevel = realRolelevel;
	}	
	
	public String getWageJobs() {
		return wageJobs;
	}

	public void setWageJobs(String wageJobs) {
		this.wageJobs = wageJobs;
	}	
	
	public String getProfessionalType() {
		return professionalType;
	}

	public void setProfessionalType(String professionalType) {
		this.professionalType = professionalType;
	}	
	
	public Date getReviewJobtime() {
		return reviewJobtime;
	}

	public void setReviewJobtime(Date reviewJobtime) {
		this.reviewJobtime = reviewJobtime;
	}	
	
	public String getReviewDetailed() {
		return reviewDetailed;
	}

	public void setReviewDetailed(String reviewDetailed) {
		this.reviewDetailed = reviewDetailed;
	}	
	
	public String getFulltimeTeacher() {
		return fulltimeTeacher;
	}

	public void setFulltimeTeacher(String fulltimeTeacher) {
		this.fulltimeTeacher = fulltimeTeacher;
	}	
	
	public String getBackboneTeacherlevel() {
		return backboneTeacherlevel;
	}

	public void setBackboneTeacherlevel(String backboneTeacherlevel) {
		this.backboneTeacherlevel = backboneTeacherlevel;
	}	
	
	public Date getBackboneTime() {
		return backboneTime;
	}

	public void setBackboneTime(Date backboneTime) {
		this.backboneTime = backboneTime;
	}	
	
	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}	
	
	public String getClassTeachertime() {
		return classTeachertime;
	}

	public void setClassTeachertime(String classTeachertime) {
		this.classTeachertime = classTeachertime;
	}	
	
	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}	
	
	public String getIdentities() {
		return identities;
	}

	public void setIdentities(String identities) {
		this.identities = identities;
	}	
	
	public Date getComeMyschooltime() {
		return comeMyschooltime;
	}

	public void setComeMyschooltime(Date comeMyschooltime) {
		this.comeMyschooltime = comeMyschooltime;
	}	
	
	public String getSchoolAge() {
		return schoolAge;
	}

	public void setSchoolAge(String schoolAge) {
		this.schoolAge = schoolAge;
	}	
	
	public Date getParticipateEducationtime() {
		return participateEducationtime;
	}

	public void setParticipateEducationtime(Date participateEducationtime) {
		this.participateEducationtime = participateEducationtime;
	}	
	
	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}	
	
	public String getContinuousLengthservice() {
		return continuousLengthservice;
	}

	public void setContinuousLengthservice(String continuousLengthservice) {
		this.continuousLengthservice = continuousLengthservice;
	}	
	
	public Date getEmploymentInitialtime() {
		return employmentInitialtime;
	}

	public void setEmploymentInitialtime(Date employmentInitialtime) {
		this.employmentInitialtime = employmentInitialtime;
	}	
	
	public String getEmploymentFixedyear() {
		return employmentFixedyear;
	}

	public void setEmploymentFixedyear(String employmentFixedyear) {
		this.employmentFixedyear = employmentFixedyear;
	}	
	
	public Date getEmploymentEndtime() {
		return employmentEndtime;
	}

	public void setEmploymentEndtime(Date employmentEndtime) {
		this.employmentEndtime = employmentEndtime;
	}	
	
	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}	
	
	public String getTechnicalTitle() {
		return technicalTitle;
	}

	public void setTechnicalTitle(String technicalTitle) {
		this.technicalTitle = technicalTitle;
	}	
	
	public Date getTechnicalTitletime() {
		return technicalTitletime;
	}

	public void setTechnicalTitletime(Date technicalTitletime) {
		this.technicalTitletime = technicalTitletime;
	}	
	
	public Date getLowlevelReviewtime() {
		return lowlevelReviewtime;
	}

	public void setLowlevelReviewtime(Date lowlevelReviewtime) {
		this.lowlevelReviewtime = lowlevelReviewtime;
	}	
	
	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}	
	
	public String getRelativesArmy() {
		return relativesArmy;
	}

	public void setRelativesArmy(String relativesArmy) {
		this.relativesArmy = relativesArmy;
	}	
	
	public String getTeachersQcnum() {
		return teachersQcnum;
	}

	public void setTeachersQcnum(String teachersQcnum) {
		this.teachersQcnum = teachersQcnum;
	}	
	
	public String getOralEnglishlevel() {
		return oralEnglishlevel;
	}

	public void setOralEnglishlevel(String oralEnglishlevel) {
		this.oralEnglishlevel = oralEnglishlevel;
	}	
	
	public Date getOralEnglishtime() {
		return oralEnglishtime;
	}

	public void setOralEnglishtime(Date oralEnglishtime) {
		this.oralEnglishtime = oralEnglishtime;
	}	
	
	public String getOralEnglishlevelnum() {
		return oralEnglishlevelnum;
	}

	public void setOralEnglishlevelnum(String oralEnglishlevelnum) {
		this.oralEnglishlevelnum = oralEnglishlevelnum;
	}	
	
	public String getComputerLevel() {
		return computerLevel;
	}

	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}	
	
	public Date getComputerLeveltime() {
		return computerLeveltime;
	}

	public void setComputerLeveltime(Date computerLeveltime) {
		this.computerLeveltime = computerLeveltime;
	}	
	
	public String getComputerLevelnum() {
		return computerLevelnum;
	}

	public void setComputerLevelnum(String computerLevelnum) {
		this.computerLevelnum = computerLevelnum;
	}	
	
	public String getMandarinLevel() {
		return mandarinLevel;
	}

	public void setMandarinLevel(String mandarinLevel) {
		this.mandarinLevel = mandarinLevel;
	}	
	
	public Date getPutonghuaGradetime() {
		return putonghuaGradetime;
	}

	public void setPutonghuaGradetime(Date putonghuaGradetime) {
		this.putonghuaGradetime = putonghuaGradetime;
	}	
	
	public String getPutonghuaGradenum() {
		return putonghuaGradenum;
	}

	public void setPutonghuaGradenum(String putonghuaGradenum) {
		this.putonghuaGradenum = putonghuaGradenum;
	}	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}	
	
	public String getPartDepartmentid() {
		return partDepartmentid;
	}

	public void setPartDepartmentid(String partDepartmentid) {
		this.partDepartmentid = partDepartmentid;
	}	
	
	public String getHighestRecord() {
		return highestRecord;
	}

	public void setHighestRecord(String highestRecord) {
		this.highestRecord = highestRecord;
	}	
	
	public String getHighestRecordschool() {
		return highestRecordschool;
	}

	public void setHighestRecordschool(String highestRecordschool) {
		this.highestRecordschool = highestRecordschool;
	}	
	
	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}	
	
	public String getHighestDegreeschool() {
		return highestDegreeschool;
	}

	public void setHighestDegreeschool(String highestDegreeschool) {
		this.highestDegreeschool = highestDegreeschool;
	}	
	
	public Date getHaveJob() {
		return haveJob;
	}

	public void setHaveJob(Date haveJob) {
		this.haveJob = haveJob;
	}	
	
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}	
	
	public String getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}	
	
	public String getAdministrativeDuties() {
		return administrativeDuties;
	}

	public void setAdministrativeDuties(String administrativeDuties) {
		this.administrativeDuties = administrativeDuties;
	}	
	
	public String getItemAthand() {
		return itemAthand;
	}

	public void setItemAthand(String itemAthand) {
		this.itemAthand = itemAthand;
	}	
	
	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}	
	
	public String getMonthlyWages() {
		return monthlyWages;
	}

	public void setMonthlyWages(String monthlyWages) {
		this.monthlyWages = monthlyWages;
	}	
	
	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}	
	
	public String getTeacherCertificationtype() {
		return teacherCertificationtype;
	}

	public void setTeacherCertificationtype(String teacherCertificationtype) {
		this.teacherCertificationtype = teacherCertificationtype;
	}	
	
	public Date getDateFromteaching() {
		return dateFromteaching;
	}

	public void setDateFromteaching(Date dateFromteaching) {
		this.dateFromteaching = dateFromteaching;
	}	
	
	public String getClassroomLearningperiod() {
		return classroomLearningperiod;
	}

	public void setClassroomLearningperiod(String classroomLearningperiod) {
		this.classroomLearningperiod = classroomLearningperiod;
	}	
	
	public String getProfessionalTechnical() {
		return professionalTechnical;
	}

	public void setProfessionalTechnical(String professionalTechnical) {
		this.professionalTechnical = professionalTechnical;
	}	
	
	public String getFulltime() {
		return fulltime;
	}

	public void setFulltime(String fulltime) {
		this.fulltime = fulltime;
	}	
	
	public String getThreeTeacherstraining() {
		return threeTeacherstraining;
	}

	public void setThreeTeacherstraining(String threeTeacherstraining) {
		this.threeTeacherstraining = threeTeacherstraining;
	}	
	
	public String getFreeNormal() {
		return freeNormal;
	}

	public void setFreeNormal(String freeNormal) {
		this.freeNormal = freeNormal;
	}	
	
	public String getSpecialpostTeacher() {
		return specialpostTeacher;
	}

	public void setSpecialpostTeacher(String specialpostTeacher) {
		this.specialpostTeacher = specialpostTeacher;
	}	
	
	public Date getProfessionalTechnology() {
		return professionalTechnology;
	}

	public void setProfessionalTechnology(Date professionalTechnology) {
		this.professionalTechnology = professionalTechnology;
	}	
	
	public Date getTogetHighestRecord() {
		return togetHighestRecord;
	}

	public void setTogetHighestRecord(Date togetHighestRecord) {
		this.togetHighestRecord = togetHighestRecord;
	}	
	
	public Date getParty() {
		return party;
	}

	public void setParty(Date party) {
		this.party = party;
	}	


	
}  
