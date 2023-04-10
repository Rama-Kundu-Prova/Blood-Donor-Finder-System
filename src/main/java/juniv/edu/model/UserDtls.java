package juniv.edu.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="user_dtls")
public class UserDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String userAge;
	private String userPhone;
	private String userBloodGroup;
	private String email;
	private String userPassword;
	private String status;
	private String usergender;
	private String userDivision;
	private String userDistrict;
	private String userThana;
	private String userUnion;
	private String role;
	private boolean enable;
	private String verificationCode;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserBloodGroup() {
		return userBloodGroup;
	}
	public void setUserBloodGroup(String userBloodGroup) {
		this.userBloodGroup = userBloodGroup;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public String getUserDivision() {
		return userDivision;
	}
	public void setUserDivision(String userDivision) {
		this.userDivision = userDivision;
	}
	public String getUserDistrict() {
		return userDistrict;
	}
	public void setUserDistrict(String userDistrict) {
		this.userDistrict = userDistrict;
	}
	public String getUserThana() {
		return userThana;
	}
	public void setUserThana(String userThana) {
		this.userThana = userThana;
	}
	public String getUserUnion() {
		return userUnion;
	}
	public void setUserUnion(String userUnion) {
		this.userUnion = userUnion;
	}
	@Override
	public String toString() {
		return "UserDtls [id=" + id + ", userName=" + userName + ", userAge=" + userAge + ", userPhone=" + userPhone
				+ ", userBloodGroup=" + userBloodGroup + ", email=" + email + ", userPassword=" + userPassword
				+ ", status=" + status + ", usergender=" + usergender + ", userDivision=" + userDivision
				+ ", userDistrict=" + userDistrict + ", userThana=" + userThana + ", userUnion=" + userUnion + "]";
	}




	

}
