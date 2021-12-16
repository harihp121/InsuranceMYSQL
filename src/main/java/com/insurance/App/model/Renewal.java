package com.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Renewal {
	@Id
	private String PolicyNumber;
	@Column(nullable=false)
	private String PolicyHolderName;
	@Column(nullable=false)
	private String ExpiryDate;
	@Column(nullable=false)
	private String RenewalDate;
	@Column(nullable=false)
	private String claimStatus;
	public String getPolicyNumber() {
		return PolicyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		PolicyNumber = policyNumber;
	}
	public String getPolicyHolderName() {
		return PolicyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		PolicyHolderName = policyHolderName;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	public String getRenewalDate() {
		return RenewalDate;
	}
	public void setRenewalDate(String renewalDate) {
		RenewalDate = renewalDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	
	

}
