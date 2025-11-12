package com.vehicle.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicle_id;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "brand")
	
	private String brand;
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	@Column(name = "daily_rent")
	private double dailyRentalRate;
	@Column (name = "availibility")
	private boolean available;

}
