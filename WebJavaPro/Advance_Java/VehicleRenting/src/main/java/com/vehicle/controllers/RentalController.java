package com.vehicle.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.dtos.RentingDto;
import com.vehicle.service.RentalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rental")
@AllArgsConstructor
public class RentalController {

	private RentalService rentalService;

	@PostMapping("/rent")
	public ResponseEntity<?> rentaVehicle(@RequestBody RentingDto rentingDto) {
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rentalService.rentVehicle(rentingDto));
	}
	
	@PutMapping("/return/{rentalId}")
	public ResponseEntity<?> returnVehicle(@PathVariable Long rentalId ){
		
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rentalService.returnVehicle(rentalId));
	}

}
