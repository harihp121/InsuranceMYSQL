package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Signup;

@Repository
public interface SignupRepository extends JpaRepository<Signup,String> {
	
	Signup findUserBymailId(String mailId);
	
	//Optional<Signup> findOne(String emailID);
//	@Query("select mail_id,first_name,last_name,phone_number from signup WHERE mail_id=:mailId and password=:password")
//	List<Signup> loginCheck(@Param("mailId") String mailId,String password);

}
