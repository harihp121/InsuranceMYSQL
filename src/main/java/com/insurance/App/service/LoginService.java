package com.insurance.service;

import com.insurance.model.Signup;

public interface LoginService {
	
	Signup findBymailId(String mailId);
	
	Signup saveUser(Signup signup);

}
