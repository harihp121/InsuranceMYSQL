package com.insurance.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.TwoWheelerPlans;
import com.insurance.repository.TwoWheelerPlanRepository;

@RestController
@RequestMapping(value="api/twowheelerinsurance")
public class TwoWheelerPlanController {
	@Autowired
	TwoWheelerPlanRepository repo;
	String line="";
	String seperator=",";
	
	@RequestMapping("/importplans")
	public ResponseEntity<Object> savePlans() throws FileNotFoundException
	{
		
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\harip\\OneDrive\\Desktop\\Insurance CSV\\Vehicle_plans.csv"));
		try {
			while((line=((BufferedReader) br).readLine())!=null){
					String[] data=line.split(seperator);
					TwoWheelerPlans plan= new TwoWheelerPlans();
					plan.setPlanId(data[0]);
					plan.setPlanName(data[1]);
					plan.setPlanType(data[2]);
					plan.setPremium(data[3]);
					plan.setClaimMade(data[4]);
					plan.setInsurerName(data[5]);
					repo.save(plan);
					
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/plantype/{planType}/claim-made/{claimMade}")

	public ResponseEntity<List<TwoWheelerPlans>> VehiclePlansByPlanType(@PathVariable String planType,@PathVariable String claimMade) {
	
		System.out.println(planType);
		System.out.println(claimMade);
			return new ResponseEntity<>(repo.getTwoWheelerPlansByPlanType(planType,claimMade),HttpStatus.ACCEPTED);
	}

}
