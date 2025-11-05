package com.healthcare.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.BookAppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Status;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository appointmentRepository;
	private final DoctorRepository doctorRepository;
	private final PatientRepository patientRepository;
	@Override
	public List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId) {
		// by patient id
		return appointmentRepository.getPatientUpcomingAppointmentsByPatientId(patientId,Status.SCHEDULED);
		//by user id
//		return appointmentRepository.getPatientUpcomingAppointmentsByUserId2(userId,Status.SCHEDULED,LocalDateTime.now());
		
	}
	@Override
	public Appointment bookAppointment(Long patientId, BookAppointmentDTO appointmentDTO) {
		if(appointmentRepository.existsByMyPatientId(patientId)) {
			Appointment appointment = new Appointment(appointmentDTO.getTs(), Status.SCHEDULED, doctorRepository.findById(appointmentDTO.getDoc_id()).orElseThrow(()->new ResourceNotFoundException("not found")),patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("not found")));
			appointmentRepository.save(appointment);
			return  appointment;
			
		}
		throw new ResourceNotFoundException("error in booking");
	}

}
