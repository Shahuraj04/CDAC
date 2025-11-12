package com.vehicle.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.dtos.CreationDto;
import com.vehicle.dtos.VehicleDto;
import com.vehicle.entities.Vehicle;
import com.vehicle.repository.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

	private final VehicleRepository vehicleRepository;
	private final ModelMapper mapper;

	@Override
	public CreationDto addVehicle(VehicleDto vehicleDto) {
		
		
		Vehicle  vehicle= mapper.map(vehicleDto, Vehicle.class);
		vehicleRepository.save(vehicle);
		CreationDto creationDto = new CreationDto("New Vehicle added", "CREATED");
		return creationDto;
	}

}
