package com.vehicle.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.dtos.VehicleDto;
import com.vehicle.service.VehicleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {

	private final VehicleService vehicleService;

	@PostMapping("/addvehicle")
	public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(vehicleDto));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(vehicleDto));
			
		}
		

	}

}
