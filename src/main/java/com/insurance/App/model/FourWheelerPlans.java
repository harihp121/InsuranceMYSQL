package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FourWheelerPlans {
	@Id
	String planId;
	String planType;
	String planName;
	String premium;
	String claimMade;
	String insurerName;
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getClaimMade() {
		return claimMade;
	}
	public void setClaimMade(String claimMade) {
		this.claimMade = claimMade;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	
	

}
