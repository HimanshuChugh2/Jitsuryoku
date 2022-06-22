package nec.jr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Type;

@Entity
public class CertificationFiles {

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String certificationFile;
	private String fileName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;

	@OneToOne(mappedBy = "theCertificationFiles")
 	private Skill skill;

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public CertificationFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

	public CertificationFiles(String certificationFile, String fileName, int id, String username,
			nec.jr.entity.Skill skill) {
		super();
		this.certificationFile = certificationFile;
		this.fileName = fileName;
		this.id = id;
		this.username = username;
		this.skill = skill;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

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

	public String getCertificationFile() {
		return certificationFile;
	}

	public void setCertificationFile(String certificationFile) {
		this.certificationFile = certificationFile;
	}
}