package nec.jr.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private int id;
	private int employeeId;
	private String bandName;
	private String managerName;
	private String desiredLevel;
	private String username;
	private String skillName;
	private String skillCategory;
	private String currentLevel;

	private boolean certificationFileUploadedFlag;
	private String fileName;
	private String certificationDate;
	private boolean gap;
	private boolean primarySkill;
	private boolean approvalStatus;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private CertificationFiles theCertificationFiles;

	// see imitiazvid about how to make foreign keys

	public int getId() {
		return id;
	}

	public CertificationFiles getTheCertificationFiles() {
		return theCertificationFiles;
	}

	public void setTheCertificationFiles(CertificationFiles theCertificationFiles) {
		this.theCertificationFiles = theCertificationFiles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public boolean isCertificationFileUploadedFlag() {
		return certificationFileUploadedFlag;
	}

	public void setCertificationFileUploadedFlag(boolean certificationFileUploadedFlag) {
		this.certificationFileUploadedFlag = certificationFileUploadedFlag;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}

	 
	 
	public String getDesiredLevel() {
		return desiredLevel;
	}

	public void setDesiredLevel(String desiredLevel) {
		this.desiredLevel = desiredLevel;
	}

	 

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public boolean isGap() {
		return gap;
	}

	public void setGap(boolean gap) {
		this.gap = gap;
	}

	public boolean isPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(boolean primarySkill) {
		this.primarySkill = primarySkill;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Skill(int id, int employeeId, String bandName, String managerName, String desiredLevel, String username,
			String skillName, String skillCategory, String currentLevel, boolean certificationFileUploadedFlag,
			String fileName, String certificationDate, boolean gap, boolean primarySkill, boolean approvalStatus,
			CertificationFiles theCertificationFiles) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.bandName = bandName;
		this.managerName = managerName;
		this.desiredLevel = desiredLevel;
		this.username = username;
		this.skillName = skillName;
		this.skillCategory = skillCategory;
		this.currentLevel = currentLevel;
		this.certificationFileUploadedFlag = certificationFileUploadedFlag;
		this.fileName = fileName;
		this.certificationDate = certificationDate;
		this.gap = gap;
		this.primarySkill = primarySkill;
		this.approvalStatus = approvalStatus;
		this.theCertificationFiles = theCertificationFiles;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
}