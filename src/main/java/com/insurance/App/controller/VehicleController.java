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

import com.insurance.model.Vehicle_Insurance;
import com.insurance.repository.VehicleRepository;
@RestController
@RequestMapping(value="api/vehicleinsurance")
public class VehicleController {
	@Autowired
	VehicleRepository vehicle;
	
	@PostMapping("/vehicle")
	public Vehicle_Insurance addUser(@RequestBody Vehicle_Insurance insure)
	{
		vehicle.save(insure);
		return insure;
	}
	
	@GetMapping("/vehicle")
	public List<Vehicle_Insurance> getUsers()
	{
		return vehicle.findAll();
	}
	
	@RequestMapping("/vehicle/{phoneNumber}")
	public Optional<Vehicle_Insurance> getUser(@PathVariable("phoneNumber") Long phoneNumber )
	{
		return vehicle.findById(phoneNumber);
	}

}
