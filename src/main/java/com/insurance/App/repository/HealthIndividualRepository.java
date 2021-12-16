package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.Health_Individual;

public interface HealthIndividualRepository extends JpaRepository<Health_Individual,Long> {

}
