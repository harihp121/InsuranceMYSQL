package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.model.TwoWheelerPlans;

public interface TwoWheelerPlanRepository extends JpaRepository<TwoWheelerPlans,String>{

	
	@Query("SELECT u from TwoWheelerPlans u where u.planType=?1 and u.claimMade=?2")	
	List<TwoWheelerPlans> getTwoWheelerPlansByPlanType(String planType, String claimMade);

}
