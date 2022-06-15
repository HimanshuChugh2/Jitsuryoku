package nec.jr.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class Skill {
	@Id	
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String skillName;
	private String skillCategory;
	private String currentlevel;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String certificationFile;
	private String fileName;
	private String certificationDate;

	public Skill(int id, String skillName, String skillCategory, String currentlevel, String certificationFile,
			String fileName, String certificationDate, String username) {
		super(); 
		this.id = id;
		this.skillName = skillName;
		this.skillCategory = skillCategory;
		this.currentlevel = currentlevel ;
		this.certificationFile = certificationFile;
		this.fileName = fileName;
		this.certificationDate = certificationDate;
		this.username= username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setCurrentlevel(String currentlevel) {
		this.currentlevel = currentlevel;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getCurrentlevel() {
		return currentlevel;
	}

	public void setLevel(String currentlevel) {
		this.currentlevel = currentlevel;
	}

	public String getCertificationFile() {
		return certificationFile;
	}

	public void setCertificationFile(String certificationFile) {
		this.certificationFile = certificationFile;
	}

	public String getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(String certificationAcquiredDate) {
		certificationDate = certificationAcquiredDate;
	}

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}	
}