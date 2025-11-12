package com.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	
	

}
