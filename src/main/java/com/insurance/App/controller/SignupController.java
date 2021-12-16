package com.insurance.App.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Login;
import com.insurance.model.Signup;
import com.insurance.repository.SignupRepository;
import com.insurance.service.LoginService;


@RestController
@RequestMapping(value="api/insurance")
public class SignupController
{
	@Autowired
	LoginService service;
	
	
	@Autowired
	SignupRepository signupRepository ;
	
	//To secure the user detail encrypt the password
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/signup")
//	public ResponseEntity<Signup> addUser(@RequestBody Signup signup)
//	{
//		String encodedPassword = passwordEncoder.encode(signup.getPassword());
//		((Signup) signupRepository).setPassword(encodedPassword);
//		return new ResponseEntity<Signup>(signupRepository.newUser(signup),HttpStatus.CREATED);
//	}
	public ResponseEntity<Signup> saveUser(@RequestBody Signup signup)
	  {
		  
		  String encodedPassword = passwordEncoder.encode(signup.getPassword());
		  signup.setPassword(encodedPassword);
		  return new ResponseEntity<Signup>(service.saveUser(signup), HttpStatus.CREATED);
	  }
	
	@GetMapping("/signup")
	public List<Signup> getUser()
	{
		return signupRepository.findAll();
	}
	
	@RequestMapping("/signup/{mailId}")
	public Optional<Signup> getUser(@PathVariable("mailId") String mailId )
	{
		return signupRepository.findById(mailId);
	}
	
	
	
	@RequestMapping(value = "/login")//,method=RequestMethod.GET)
	public ResponseEntity<Signup> login(@RequestBody Login login) {
		String mailid=login.getMailId();
		String userPassword=login.getPassword(); 
		Signup alreadyUser =(Signup)service.findBymailId(mailid);
		String password="",mailId="";
		try 
		{
			password=alreadyUser.getPassword();
			mailId=alreadyUser.getmailId();
		}
		
	    catch(NullPointerException exception) 
		{
	    	System.out.println(exception);
		}
		if(mailId.equalsIgnoreCase(mailid)&&passwordEncoder.matches(userPassword,password))
		{		
	         return new ResponseEntity<Signup>(alreadyUser,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<> (HttpStatus.BAD_GATEWAY);
	}
	
	
	
//	@RequestMapping("/allplans/{emailID}")
//	@Query("select Mail_ID, name, DOB, occupation, medicalHistory from Health_individual union select mail_id,name,DOB,occupation,medicalHistory from Health_family")
//	public Optional<Signup> allPlan(@PathVariable ("emailID") String emailID)
//	{
//		return signupRepository.findOne(emailID);
//	}
	
//	@RequestMapping("/login")
//	public boolean loginVerify(String mailId, String password)// throws DataNotFoundEcxeption
//	{
//		List<Signup> list = signupRepository.loginCheck(mailId, password);
//
//		if (list.size() > 0)
//		return true;
//		else
//		//throw new DataNotFoundEcxeption();
//		 return false;
//
//		}
//	
	
	// Login using rest api

	/*
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public ResponseEntity<Signup> login(@RequestBody Login login) {
	//System.out.println("Hello");
	String mailId=login.getMailId();
	String userPassword=login.getPassword();
	System.out.println(mailId);
	System.out.println(userPassword);
	Signup signup =(Signup)service.findBymailId(mailId);
	String password="",username="";
	try {
	password=signup.getPassword();
	username=signup.getmailId();
	}

	    catch(NullPointerException e) {
	}
	System.out.println(username);
	System.out.println(password);
	if(username.equalsIgnoreCase(mailId)&&password.equalsIgnoreCase(userPassword))
	{
	System.out.println(password);
	return new ResponseEntity<Signup>(signup,HttpStatus.ACCEPTED);
	}
	return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}

	*/
}
	





