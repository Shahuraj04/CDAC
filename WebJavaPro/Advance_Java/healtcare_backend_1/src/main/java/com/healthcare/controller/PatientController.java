package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.BookAppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.service.AppointmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
	// depcy
	private final AppointmentService appointmentService;

	/*
	 * Desc - List patient's upcoming appointments End Point design URL -
	 * http://host:port/patients/1/appointments/upcoming Method- GET resource id -
	 * path var. Resp - List<AppointmentDTO> Main highlight - custom query - JPQL
	 * i/p - user id.
	 */
	@GetMapping("/{patientId}/appointments/upcoming")
	public ResponseEntity<?> listUpcomingAppointments(@PathVariable Long patientId) {
		System.out.println("in patient list appointments " + patientId);
		// invoker service layer method
		try {
			return ResponseEntity.ok(appointmentService.listUpcomingPatientAppointments(patientId));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND) // SC 404
					.body(new ApiResponse(e.getMessage(), "failed"));
		}
	}

	@PostMapping("/{patientId}/appointments/book")
	public ResponseEntity<?> bookAppointment(@PathVariable Long patientId,
			@org.springframework.web.bind.annotation.RequestBody BookAppointmentDTO appointmentDTO) {
		try {
			Appointment bookAppointment = appointmentService.bookAppointment(patientId, appointmentDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(bookAppointment);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		
	}

}
