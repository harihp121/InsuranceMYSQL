package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.model.HealthPlans;

public interface HealthPlansRepository extends JpaRepository<HealthPlans,String>{
	
	//List<HealthPlans> findByTypeAndHealth(String planType, String existingIllness);

	@Query("SELECT u from HealthPlans u where u.planType=?1 and u.existingIllness=?2")	
	public List<HealthPlans> getHealthPlansByPlanType(String planType,String existingIllness);
	
	//List<HealthPlans> getHealthPlansByExistingIllness(String existingIllness);
}
