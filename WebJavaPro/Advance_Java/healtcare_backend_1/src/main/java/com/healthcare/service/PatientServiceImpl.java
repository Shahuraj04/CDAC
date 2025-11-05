package com.healthcare.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceAlreadyExists;
import com.healthcare.dto.RegisterDTO;
import com.healthcare.entities.Patient;
import com.healthcare.entities.User;
import com.healthcare.repository.PatientRepository;
import com.healthcare.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final ModelMapper modelMapper;

	private final PatientRepository patientRepository;
	private final UserRepository userRepository;

	@Override
	public RegisterDTO registerPatient(RegisterDTO dto) {

		
		User user = new User();
		user.setFirstName(dto.getUser().getFirstName());
		user.setLastName(dto.getUser().getLastName());
		user.setEmail(dto.getUser().getEmail());
		user.setPassword(dto.getUser().getPassword());
		user.setPhone(dto.getUser().getPhone());
		user.setDob(dto.getUser().getDob());
		user.setRegAmount(dto.getUser().getRegAmount());

 		if (userRepository.existsByEmail(user.getEmail())) {
			throw new ResourceAlreadyExists("Email already registered!");
		}

		Patient patient = new Patient(dto.getGender(), dto.getBloodGroup(), dto.getFamilyHistory(), user, null);

		patientRepository.save(patient);

		return dto;
	}

}
