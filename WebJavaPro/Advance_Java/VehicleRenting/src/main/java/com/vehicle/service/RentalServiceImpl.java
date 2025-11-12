package com.vehicle.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.controllers.ApiResponse;
import com.vehicle.dtos.RentingDto;
import com.vehicle.entities.Rental;
import com.vehicle.entities.Vehicle;
import com.vehicle.exceptions.ResourceAlreadyExistException;
import com.vehicle.exceptions.ResourceNotFoundException;
import com.vehicle.repository.RentalRepository;
import com.vehicle.repository.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RentalServiceImpl implements RentalService {

	private final RentalRepository rentalRepository;
	private final VehicleRepository vehicleRepository;
	private final ModelMapper mapper;

	@Override
	public ApiResponse rentVehicle(RentingDto rentingDto) {

		Rental rental = mapper.map(rentingDto, Rental.class);

		Vehicle vehicle = vehicleRepository.findById(rentingDto.getVehicleId())
				.orElseThrow(() -> new ResourceAlreadyExistException("Vehicle not found!"));

		if (!vehicle.isAvailable()) {
			return new ApiResponse("Vehicle is not available for renting", "FAILED");
		}
		if (rentingDto.getStartDate().isAfter(rentingDto.getEndDate())) {
			throw new ResourceAlreadyExistException("add valid date");
		}
//	    Period period = Period.between(rentingDto.getStartDate(),rentingDto.getEndDate());
		long days = java.time.temporal.ChronoUnit.DAYS.between(rentingDto.getStartDate(), rentingDto.getEndDate());
		rental.setTotal(days * vehicle.getDailyRentalRate());

		rental.setVehicle(vehicle);

		vehicle.setAvailable(false);

		rentalRepository.save(rental);
		vehicleRepository.save(vehicle);

		return new ApiResponse("Booked successfully", "created");
	}

	@Override
	public ApiResponse returnVehicle(Long rentalId) {
		Rental rental = rentalRepository.findById(rentalId).orElseThrow(()->new ResourceNotFoundException("not such id"));
		Vehicle vehicle = rental.getVehicle();
		vehicle.setAvailable(true);
		vehicleRepository.save(vehicle);
		return new ApiResponse("Made Available", "AVAILABLE");
	}

}
