package com.healthcare.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Status;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select new com.healthcare.dto.AppointmentDTO(a.id, a.appointmentDateTime,a.myDoctor.userDetails.firstName, a.myDoctor.userDetails.lastName) FROM Appointment a WHERE a.myPatient.userDetails.id=:patientId and a.status=:sts")
	List<AppointmentDTO> getAllAppointments(Long patientId, Status sts);

	Optional<Appointment> findByMyDoctorAndAppointmentDateTime(Long docId, LocalDateTime dateTime);

}
