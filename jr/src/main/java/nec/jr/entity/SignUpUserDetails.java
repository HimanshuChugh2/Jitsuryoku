package nec.jr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sign_up")
public class SignUpUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

//  		@Pattern(regexp= "/[一-龠]+|[ぁ-ゔ]+|[ァ-ヴー]+|[a-zA-Z ]+|[ａ-ｚＡ-Ｚ ]+|[々〆〤]+/u",message = "-> It must be an appropriate name. "  )
	// i have added whitespace afterA-Z to let it take white space between words

	@Size(min = 1, max = 50, message = "-> User Profile Name must be greater than 1 character")
	@Pattern(regexp = "^[\\$#\\+{}:\\?\\.\\_,~\"a-zA-Z0-9]+$", message = "-> It must be an appropriate name. \n\n <br/> <hr/> It should not contain whitespace.\r\n Special charaters like 'period' and 'underscore' are only allowed")

	private String name;

	private String role = "ROLE_ADMIN";

	@Size(min = 3, max = 30)
	private String password;

	@NotBlank
	@Size(min = 5, max = 50, message = "-> Name must be greater than 3 characters ")
	@Email
	private String username;

 	private String reportingManager;

	public SignUpUserDetails(int id,

			String name, String role, @Size(min = 3, max = 30) String password,
			@NotBlank @Size(min = 5, max = 50, message = "-> Name must be greater than 3 characters ") @Email String username,
			 String reportingManager) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.username = username;
 		this.reportingManager = reportingManager;
	}

 

	/*
	 * private int workingHours; private int commuteTime; private int workoutTime;
	 * private int mealTime;
	 * 
	 * private int phoneTime; private int sleepTime;
	 */

	public SignUpUserDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public void setId(int id) {
		this.id = id;
	}

 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

 

}
