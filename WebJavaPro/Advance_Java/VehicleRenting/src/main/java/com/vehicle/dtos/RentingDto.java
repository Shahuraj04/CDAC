package com.vehicle.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentingDto {

	@NotNull
	private String mobileNo;
	@NotNull
	private String name;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	
	@NotNull
	private Long vehicleId;

}
