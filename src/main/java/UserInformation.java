
public class UserInformation {
private String fullName;
private String accountNumber;
private String phoneNumber;
private Double intialDeposit;
private String password;
private String confirmPassword;
// constractor 
public UserInformation(String fullName, String accountNumber, String phoneNumber, Double intialDeposit, String password,String confirmPassword) {
	//super();
	this.fullName = fullName;
	this.accountNumber = accountNumber;
	this.phoneNumber = phoneNumber;
	this.intialDeposit = intialDeposit;
	this.password = password;
	this.confirmPassword = confirmPassword;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Double getIntialDeposit() {
	return intialDeposit;
}
public void setIntialDeposit(Double intialDeposit) {
	this.intialDeposit = intialDeposit;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

}
