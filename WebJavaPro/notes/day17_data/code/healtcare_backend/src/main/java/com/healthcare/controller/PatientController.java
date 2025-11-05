package com.healthcare.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.PatientService;

import lombok.AllArgsConstructor;

//http://host:port/patients/{patientId}/appointments/upcoming
//method GET
//resourceId = @Pathvariable
//Response List<AppointmentDTO>
@RestController
@RequestMapping("/patients")
@AllArgsConstructor

public class PatientController {

	private final PatientService patientService;
	private final AppointmentService appointmentService;
	
	@GetMapping("/{patientId}/appointments/upcoming")
	public ResponseEntity<?> getAllAppointments(@PathVariable Long patientId){
		
		
		
		try {
			List<AppointmentDTO> appointments = appointmentService.getAppointments(patientId);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(appointments);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
}
