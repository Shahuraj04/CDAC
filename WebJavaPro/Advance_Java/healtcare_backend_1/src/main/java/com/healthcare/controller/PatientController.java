package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.BookAppointmentDTO;
import com.healthcare.dto.RegisterDTO;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;
	// depcy
	private final AppointmentService appointmentService;
	private final PatientService patientService;
    


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
			
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(patientId, appointmentDTO));
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		
	}
	@PostMapping("/registerpatient")
	public ResponseEntity<?> registerPatient(@RequestBody RegisterDTO dto){
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(patientService.registerPatient(dto));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		
	}

}
