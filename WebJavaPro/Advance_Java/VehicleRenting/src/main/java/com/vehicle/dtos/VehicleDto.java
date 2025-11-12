package com.vehicle.dtos;

import com.vehicle.entities.VehicleType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
	@NotBlank
	private String modelName;
	@NotNull
	private String brand;
	@NotNull
	private VehicleType type;
	@NotNull
	private double dailyRentalRate;
	@NotNull
	private boolean available;
	
	
}
