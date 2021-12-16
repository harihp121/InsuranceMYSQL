package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.Renewal;

public interface RenewalRepository extends JpaRepository<Renewal,String>{

}
