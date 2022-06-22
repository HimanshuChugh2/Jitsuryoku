package nec.jr.wrapper;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import nec.jr.entity.CertificationFiles;
import nec.jr.entity.Skill;

public class CertificationFileAndSkill {

	private int id;
	private String username;
	private String skillName;
	private String skillCategory;
	private String currentLevel;

	private boolean certificationFileUploadedFlag;
	private String fileName;
	private String certificationDate;
	private String certificationFile;
	public int getId() {
		return id;
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
	public String getCertificationFile() {
		return certificationFile;
	}
	public void setCertificationFile(String certificationFile) {
		this.certificationFile = certificationFile;
	}
	public CertificationFileAndSkill(int id, String username, String skillName, String skillCategory,
			String currentLevel, boolean certificationFileUploadedFlag, String fileName, String certificationDate,
			String certificationFile) {
		super();
		this.id = id;
		this.username = username;
		this.skillName = skillName;
		this.skillCategory = skillCategory;
		this.currentLevel = currentLevel;
		this.certificationFileUploadedFlag = certificationFileUploadedFlag;
		this.fileName = fileName;
		this.certificationDate = certificationDate;
		this.certificationFile = certificationFile;
	}
	public CertificationFileAndSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

}
