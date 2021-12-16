package com.insurance.model;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity

public class Health_Individual {

	//@Id
	private long phoneNumber;
	@Column(nullable=false)
	private String name;
	//@Column(nullable=false)
	private String relationship;
	@Column(nullable=false)
	private String dob;
	@Column(nullable=false)
	private String gender;
	@Column(nullable=false)
	private String maritalStatus;
	@Column(nullable=false)
	private String occupation;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String mailId;
	@Id
	@SequenceGenerator(name="policynumber",initialValue=1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="policynumber")
	private int policyNumber;
	private String medicalHistory;
	
	//	public void setId(int id) {
//		this.id = id;
//	}
	

	public String getMailId() {
		return mailId;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

		
		
}
	
	 