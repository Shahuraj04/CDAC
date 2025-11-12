package com.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental,Long> {

}
