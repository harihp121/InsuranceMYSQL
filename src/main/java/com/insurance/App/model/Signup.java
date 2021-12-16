package com.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Signup {
	@Id
	private String mailId;
	@Column(nullable=false)
    private String password;
	
   // private String ConfirmPassword;
	
		
	public String getmailId() {
		return mailId;
	}
	public void setmailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Signup(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}
   
	

}
