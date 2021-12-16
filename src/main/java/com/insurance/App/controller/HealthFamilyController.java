package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Health_Family;
import com.insurance.repository.HealthFamilyRepository;
@RestController
@RequestMapping(value="api/healthinsurance")
public class HealthFamilyController {
	@Autowired
	HealthFamilyRepository family;
	
	
	@PostMapping("/family")
	public Health_Family addUser(@RequestBody Health_Family health)
	{
		family.save(health);
		return health;
	}
	
	@GetMapping("/family")
	public List<Health_Family> getUser()
	{
		return family.findAll();
	}
	
//	@RequestMapping("/healthfamily/{mailID}")
//	public Optional<Health_Family> getUser(@PathVariable("emailID") String mailID )
//	{
//		return family.findById(mailID);
//	}
	

}





