package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,String>{

}
