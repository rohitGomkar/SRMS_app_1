package SRMS_app_1.com.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="accountant")
public class Accountant extends AbstractEntity{
private String email;
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
