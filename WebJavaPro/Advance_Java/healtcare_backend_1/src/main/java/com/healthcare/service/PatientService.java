package com.healthcare.service;

import com.healthcare.dto.RegisterDTO;
import com.healthcare.entities.Patient;

public interface PatientService {

	RegisterDTO registerPatient(RegisterDTO dto);

}
