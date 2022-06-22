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
	private String username;
	private String skillName;
	private String skillCategory;
	private String currentLevel;
	private boolean certificationFileUploadedFlag;
	private String fileName;
	private String certificationDate;

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

	 
	public Skill(int id, String username, String skillName, String skillCategory, String currentLevel,
			boolean certificationFileUploadedFlag, String fileName, String certificationDate,
			CertificationFiles theCertificationFiles) {
		super();
		this.id = id;
		this.username = username;
		this.skillName = skillName;
		this.skillCategory = skillCategory;
		this.currentLevel = currentLevel;
		this.certificationFileUploadedFlag = certificationFileUploadedFlag;
		this.fileName = fileName;
		this.certificationDate = certificationDate;
		this.theCertificationFiles = theCertificationFiles;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

}