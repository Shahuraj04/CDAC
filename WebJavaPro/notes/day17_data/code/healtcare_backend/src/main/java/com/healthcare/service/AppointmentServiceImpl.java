package com.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Status;
import com.healthcare.repository.AppointmentRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentRepository appointmentRepository;

	@Override
	public List<AppointmentDTO> getAppointments(Long patientId) {
		
		List<AppointmentDTO> allAppointments = appointmentRepository.getAllAppointments(patientId,Status.SCHEDULED);
		if(allAppointments.isEmpty()) {
			throw new ResourceNotFoundException("No lists found");
		}
		else {
			return allAppointments;
		}
	}

}
