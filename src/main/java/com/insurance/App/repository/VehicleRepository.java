package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.model.Vehicle_Insurance;

public interface VehicleRepository extends JpaRepository<Vehicle_Insurance,Long>{

}
