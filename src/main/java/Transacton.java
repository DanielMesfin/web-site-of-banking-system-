
public class Transacton {
String account;
String tType;
Double amount;
public Transacton(String account, String tType, Double amount) {
	//super();
	this.account = account;
	this.tType = tType;
	this.amount = amount;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String gettType() {
	return tType;
}
public void settType(String tType) {
	this.tType = tType;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
}
