package com.healthcare.repository;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.Patient;
import com.healthcare.entities.User;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	
	Optional<Patient> findById(Long id);

	boolean existsByUserDetails(User user);

}
