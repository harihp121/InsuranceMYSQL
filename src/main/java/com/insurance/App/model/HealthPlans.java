package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HealthPlans {
	//Plan Id	Plan name	Plan type	Cover amount	Premium	Claim settlement ratio	
	//Existing illness 	Insurer Name	Policy period

	@Id
	String planId;
	String planName;
	String planType;
	String coverAmount;
	String premium;
	String settlementRatio;
	String existingIllness;
	String insurerName;
	String policyPeriod;
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getCoverAmount() {
		return coverAmount;
	}
	public void setCoverAmount(String coverAmount) {
		this.coverAmount = coverAmount;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getSettlementRatio() {
		return settlementRatio;
	}
	public void setSettlementRatio(String settlementRatio) {
		this.settlementRatio = settlementRatio;
	}
	public String getExistingIllness() {
		return existingIllness;
	}
	public void setExistingIllness(String existingIllness) {
		this.existingIllness = existingIllness;
	}
	public String getInsurerName() {
		return insurerName;
	}
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}
	public String getPolicyPeriod() {
		return policyPeriod;
	}
	public void setPolicyPeriod(String policyPeriod) {
		this.policyPeriod = policyPeriod;
	}
	
	@Override
	public String toString() {
		return "HealthPlans [planId=" + planId + ", planName=" + planName + ", planType=" + planType + ", coverAmount="
				+ coverAmount + ", premium=" + premium + ", settlementRatio=" + settlementRatio + ", existingIllness="
				+ existingIllness + ", insurerName=" + insurerName + ", policyPeriod=" + policyPeriod + "]";
	}
	
	
	
	
	

}
