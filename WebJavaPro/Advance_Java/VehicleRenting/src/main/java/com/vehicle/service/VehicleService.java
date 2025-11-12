package com.vehicle.service;

import com.vehicle.dtos.CreationDto;
import com.vehicle.dtos.VehicleDto;

public interface VehicleService {

	CreationDto addVehicle(VehicleDto vehicleDto);

}
