package com.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.model.FourWheelerPlans;

public interface FourWheelerPlanRepository extends JpaRepository<FourWheelerPlans,String>{

	@Query("SELECT u from FourWheelerPlans u where u.planType=?1 and u.claimMade=?2")
	List<FourWheelerPlans> getFourWheelerPlansByPlanType(String planType, String claimMade);

}
