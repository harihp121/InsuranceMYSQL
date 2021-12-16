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

import com.insurance.model.Profile;
import com.insurance.repository.ProfileRepository;

@RestController
@RequestMapping("api/insurance")
public class ProfileController {
	@Autowired
	ProfileRepository profileRepository;
	
	@PostMapping("profile")
	public Profile addData(@RequestBody Profile profile) 
	{
		profileRepository.save(profile);
		return profile;
	}

	@GetMapping("/profile")
	public List<Profile> getUserDetails()
	{
		return profileRepository.findAll();
	}
	
	@RequestMapping("/profile/{phoneNumber}")
	public Optional<Profile> getUserDetail(@PathVariable("mailId") String mailId )
	{
		return profileRepository.findById(mailId);
	}
	
}
