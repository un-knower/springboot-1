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
 * 创建时间：2017-07-24
 * @version
 */
@Entity
@Table(name = "telit_student")
public class TelitStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801308553966226445L;
	
	@Id	
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ID")
	private String id;
		
	@Column(name = "USER_ID")
	private String userId;
		
	@Column(name = "SCHOOL_ID")
	private String schoolId;
		
	@Column(name = "GRADE_ID")
	private String gradeId;
		
	@Column(name = "CLASS_ID")
	private String classId;
		
	@Column(name = "STUDENT_CODE")
	private String studentCode;
		
	@Column(name = "STUDENT_ID")
	private String studentId;
		
	@Column(name = "STUDENT_NAME")
	private String studentName;
		
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
		
	@Column(name = "SEX")
	private String sex;
		
	@Column(name = "ID_CARD_TYPE")
	private String idCardType;
		
	@Column(name = "ID_NUMBER")
	private String idNumber;
		
	@Column(name = "GUARDIAN")
	private String guardian;
		
	@Column(name = "GUARDIAN_IDNUMBER")
	private String guardianIdnumber;
		
	@Column(name = "LOCAL_CONTACTNAME")
	private String localContactname;
		
	@Column(name = "RELATION")
	private String relation;
		
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
		
	@Column(name = "TIME_OF_ENROLLMENT")
	private String timeOfEnrollment;
		
	@Column(name = "POLITICS_STATUS")
	private String politicsStatus;
		
	@Column(name = "TIME_JOINING_PARTY")
	private String timeJoiningParty;
		
	@Column(name = "NATIVE_CODE")
	private String nativeCode;
		
	@Column(name = "BIRTHPLACE_CODE")
	private String birthplaceCode;
		
	@Column(name = "REGISTERED_PERMANENT_RESIDENCE")
	private String registeredPermanentResidence;
		
	@Column(name = "HOME_ADDRESS")
	private String homeAddress;
		
	@Column(name = "HOME_CODE")
	private String homeCode;
		
	@Column(name = "FAMILY_CONTACT")
	private String familyContact;
		
	@Column(name = "FAMILY_TEL")
	private String familyTel;
		
	@Column(name = "ORIGINAL_SCHOOL")
	private String originalSchool;
		
	@Column(name = "ADMISSION_RESULTS")
	private String admissionResults;
		
	@Column(name = "STUDENT_TYPE")
	private String studentType;
		
	@Column(name = "NCEE_NUM")
	private String nceeNum;
		
	@Column(name = "MEDIUM_NUM")
	private String mediumNum;
		
	@Column(name = "OUTSIDE_SCHOOL_DISTRICT")
	private String outsideSchoolDistrict;
		
	@Column(name = "NONLOCAL_STUDENT")
	private String nonlocalStudent;
		
	@Column(name = "ONLY_CHILD")
	private String onlyChild;
		
	@Column(name = "LEFTOVER_CHILDREN")
	private String leftoverChildren;
		
	@Column(name = "FLOATING_POPULATION")
	private String floatingPopulation;
		
	@Column(name = "ENTRANCE_WAY")
	private String entranceWay;
		
	@Column(name = "NONREGISTERED_STUDENTS")
	private String nonregisteredStudents;
		
	@Column(name = "STUDYING_WAY")
	private String studyingWay;
		
	@Column(name = "HEALTH")
	private String health;
		
	@Column(name = "HONGKONG_AND_MACAO")
	private String hongkongAndMacao;
		
	@Column(name = "FAMILY_SITUATION")
	private String familySituation;
		
	@Column(name = "BLOOD_TYPE")
	private String bloodType;
		
	@Column(name = "SOMATOPSYCHIC_DISTURBANCE")
	private String somatopsychicDisturbance;
		
	@Column(name = "FORMER_NAME")
	private String formerName;
		
	@Column(name = "SPECIALTY")
	private String specialty;
		
	@Column(name = "REMARK")
	private String remark;
		
	@Column(name = "STATUS")
	private String status;
		
	@Column(name = "PRESCHOOL_EDUCATION")
	private String preschoolEducation;
		
	@Column(name = "ORPHAN")
	private String orphan;
		
	@Column(name = "MARTYR_CHILDREN")
	private String martyrChildren;
		
	@Column(name = "FUNDING")
	private String funding;
		
	@Column(name = "ENJOY_PATCH")
	private String enjoyPatch;
		
	@Column(name = "DISTANCE_SCHOOL")
	private String distanceSchool;
		
	@Column(name = "MODE_TRANSPORT")
	private String modeTransport;
		
	@Column(name = "TAKE_SCHOOLBUS")
	private String takeSchoolbus;
		
	@Column(name = "NATIONID")
	private String nationid;
		
	@Column(name = "DEL_FLAG")
	private String delFlag;
		
	@Column(name = "CARD_NUMBER2")
	private String cardNumber2;
		
	@Column(name = "CARD_NUMBER1")
	private String cardNumber1;
		
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}	
	
	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}	
	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}	
	
	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}	
	
	public String getGuardianIdnumber() {
		return guardianIdnumber;
	}

	public void setGuardianIdnumber(String guardianIdnumber) {
		this.guardianIdnumber = guardianIdnumber;
	}	
	
	public String getLocalContactname() {
		return localContactname;
	}

	public void setLocalContactname(String localContactname) {
		this.localContactname = localContactname;
	}	
	
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
	
	public String getTimeOfEnrollment() {
		return timeOfEnrollment;
	}

	public void setTimeOfEnrollment(String timeOfEnrollment) {
		this.timeOfEnrollment = timeOfEnrollment;
	}	
	
	public String getPoliticsStatus() {
		return politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}	
	
	public String getTimeJoiningParty() {
		return timeJoiningParty;
	}

	public void setTimeJoiningParty(String timeJoiningParty) {
		this.timeJoiningParty = timeJoiningParty;
	}	
	
	public String getNativeCode() {
		return nativeCode;
	}

	public void setNativeCode(String nativeCode) {
		this.nativeCode = nativeCode;
	}	
	
	public String getBirthplaceCode() {
		return birthplaceCode;
	}

	public void setBirthplaceCode(String birthplaceCode) {
		this.birthplaceCode = birthplaceCode;
	}	
	
	public String getRegisteredPermanentResidence() {
		return registeredPermanentResidence;
	}

	public void setRegisteredPermanentResidence(String registeredPermanentResidence) {
		this.registeredPermanentResidence = registeredPermanentResidence;
	}	
	
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}	
	
	public String getHomeCode() {
		return homeCode;
	}

	public void setHomeCode(String homeCode) {
		this.homeCode = homeCode;
	}	
	
	public String getFamilyContact() {
		return familyContact;
	}

	public void setFamilyContact(String familyContact) {
		this.familyContact = familyContact;
	}	
	
	public String getFamilyTel() {
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}	
	
	public String getOriginalSchool() {
		return originalSchool;
	}

	public void setOriginalSchool(String originalSchool) {
		this.originalSchool = originalSchool;
	}	
	
	public String getAdmissionResults() {
		return admissionResults;
	}

	public void setAdmissionResults(String admissionResults) {
		this.admissionResults = admissionResults;
	}	
	
	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}	
	
	public String getNceeNum() {
		return nceeNum;
	}

	public void setNceeNum(String nceeNum) {
		this.nceeNum = nceeNum;
	}	
	
	public String getMediumNum() {
		return mediumNum;
	}

	public void setMediumNum(String mediumNum) {
		this.mediumNum = mediumNum;
	}	
	
	public String getOutsideSchoolDistrict() {
		return outsideSchoolDistrict;
	}

	public void setOutsideSchoolDistrict(String outsideSchoolDistrict) {
		this.outsideSchoolDistrict = outsideSchoolDistrict;
	}	
	
	public String getNonlocalStudent() {
		return nonlocalStudent;
	}

	public void setNonlocalStudent(String nonlocalStudent) {
		this.nonlocalStudent = nonlocalStudent;
	}	
	
	public String getOnlyChild() {
		return onlyChild;
	}

	public void setOnlyChild(String onlyChild) {
		this.onlyChild = onlyChild;
	}	
	
	public String getLeftoverChildren() {
		return leftoverChildren;
	}

	public void setLeftoverChildren(String leftoverChildren) {
		this.leftoverChildren = leftoverChildren;
	}	
	
	public String getFloatingPopulation() {
		return floatingPopulation;
	}

	public void setFloatingPopulation(String floatingPopulation) {
		this.floatingPopulation = floatingPopulation;
	}	
	
	public String getEntranceWay() {
		return entranceWay;
	}

	public void setEntranceWay(String entranceWay) {
		this.entranceWay = entranceWay;
	}	
	
	public String getNonregisteredStudents() {
		return nonregisteredStudents;
	}

	public void setNonregisteredStudents(String nonregisteredStudents) {
		this.nonregisteredStudents = nonregisteredStudents;
	}	
	
	public String getStudyingWay() {
		return studyingWay;
	}

	public void setStudyingWay(String studyingWay) {
		this.studyingWay = studyingWay;
	}	
	
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}	
	
	public String getHongkongAndMacao() {
		return hongkongAndMacao;
	}

	public void setHongkongAndMacao(String hongkongAndMacao) {
		this.hongkongAndMacao = hongkongAndMacao;
	}	
	
	public String getFamilySituation() {
		return familySituation;
	}

	public void setFamilySituation(String familySituation) {
		this.familySituation = familySituation;
	}	
	
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}	
	
	public String getSomatopsychicDisturbance() {
		return somatopsychicDisturbance;
	}

	public void setSomatopsychicDisturbance(String somatopsychicDisturbance) {
		this.somatopsychicDisturbance = somatopsychicDisturbance;
	}	
	
	public String getFormerName() {
		return formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}	
	
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	public String getPreschoolEducation() {
		return preschoolEducation;
	}

	public void setPreschoolEducation(String preschoolEducation) {
		this.preschoolEducation = preschoolEducation;
	}	
	
	public String getOrphan() {
		return orphan;
	}

	public void setOrphan(String orphan) {
		this.orphan = orphan;
	}	
	
	public String getMartyrChildren() {
		return martyrChildren;
	}

	public void setMartyrChildren(String martyrChildren) {
		this.martyrChildren = martyrChildren;
	}	
	
	public String getFunding() {
		return funding;
	}

	public void setFunding(String funding) {
		this.funding = funding;
	}	
	
	public String getEnjoyPatch() {
		return enjoyPatch;
	}

	public void setEnjoyPatch(String enjoyPatch) {
		this.enjoyPatch = enjoyPatch;
	}	
	
	public String getDistanceSchool() {
		return distanceSchool;
	}

	public void setDistanceSchool(String distanceSchool) {
		this.distanceSchool = distanceSchool;
	}	
	
	public String getModeTransport() {
		return modeTransport;
	}

	public void setModeTransport(String modeTransport) {
		this.modeTransport = modeTransport;
	}	
	
	public String getTakeSchoolbus() {
		return takeSchoolbus;
	}

	public void setTakeSchoolbus(String takeSchoolbus) {
		this.takeSchoolbus = takeSchoolbus;
	}	
	
	public String getNationid() {
		return nationid;
	}

	public void setNationid(String nationid) {
		this.nationid = nationid;
	}	
	
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}	
	
	public String getCardNumber2() {
		return cardNumber2;
	}

	public void setCardNumber2(String cardNumber2) {
		this.cardNumber2 = cardNumber2;
	}	
	
	public String getCardNumber1() {
		return cardNumber1;
	}

	public void setCardNumber1(String cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}	


	
}  
