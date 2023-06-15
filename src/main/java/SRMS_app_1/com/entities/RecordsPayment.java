package SRMS_app_1.com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="records_payment")
public class RecordsPayment extends AbstractEntity{
private String firstName;
private String lastName;
private String courseName;
private Long amountPaid;
private Long totalAmount;
private Long balanceAmount;
private Date date;
private String email;
private String phone;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public Long getAmountPaid() {
	return amountPaid;
}
public void setAmountPaid(Long amountPaid) {
	this.amountPaid = amountPaid;
}
public Long getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Long totalAmount) {
	this.totalAmount = totalAmount;
}
public Long getBalanceAmount() {
	return balanceAmount;
}
public void setBalanceAmount(Long balanceAmount) {
	this.balanceAmount = balanceAmount;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
}
