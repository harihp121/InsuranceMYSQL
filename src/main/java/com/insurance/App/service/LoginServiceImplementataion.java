package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.Signup;
import com.insurance.repository.SignupRepository;
//@ComponentScan(basePackages= {"com.insurance.repository"})
@Service
public class LoginServiceImplementataion implements LoginService {
	@Autowired
	SignupRepository repo;

	@Override
	public Signup findBymailId(String mailId) {
		// TODO Auto-generated method stub
		return repo.findUserBymailId(mailId);
	}

	@Override
	public Signup saveUser(Signup signup) {
		// TODO Auto-generated method stub
		return repo.save(signup);
	}

}
