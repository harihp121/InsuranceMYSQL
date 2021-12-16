package com.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Health_Individual;
import com.insurance.repository.HealthIndividualRepository;

@RestController
@RequestMapping(value="api/healthinsurance")
public class HealthIndividualController {
	@Autowired
	HealthIndividualRepository individual;
	
	@PostMapping("/individual")
	public Health_Individual addUser(@RequestBody Health_Individual health)
	{
		individual.save(health);
		return health;
	}
	
	@GetMapping("/individual")
	public List<Health_Individual> getUser()
	{
		return individual.findAll();
	}
	
	@RequestMapping("/individual/{phoneNumber}")
	public Optional<Health_Individual> getUser(@PathVariable("phoneNumber") Long phoneNumber )
	{
		return individual.findById(phoneNumber);
	}
	
	
}
