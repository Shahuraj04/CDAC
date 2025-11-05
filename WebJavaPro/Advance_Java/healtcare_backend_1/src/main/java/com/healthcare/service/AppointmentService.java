package com.healthcare.service;

import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AuthResp;
import com.healthcare.dto.BookAppointmentDTO;
import com.healthcare.entities.Appointment;

public interface AppointmentService {

	List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId);

	BookAppointmentDTO bookAppointment(Long patientId, BookAppointmentDTO appointmentDTO);

}
