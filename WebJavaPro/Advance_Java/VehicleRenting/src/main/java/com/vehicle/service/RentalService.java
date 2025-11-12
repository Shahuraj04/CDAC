package com.vehicle.service;

import com.vehicle.controllers.ApiResponse;
import com.vehicle.dtos.RentingDto;

public interface RentalService {

	ApiResponse rentVehicle(RentingDto rentingDto);

	ApiResponse returnVehicle(Long rentalId);

}
