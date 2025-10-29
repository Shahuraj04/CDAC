package com.healthcare.dao;

import java.time.LocalDateTime;

import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;

public interface AppointmentDao {
	
	String bookAppointment(LocalDateTime dateTime, Long  doc_id, Long pat_id);

}
