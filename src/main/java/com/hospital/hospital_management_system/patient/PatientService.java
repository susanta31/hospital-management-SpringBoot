package com.hospital.hospital_management_system.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_management_system.doctor.Doctor;


@Service
public class PatientService {

	@Autowired 
	public PatientRepository patientRepository;
	
	public List<Patient> savePatients(List<Patient> patientList) {
		patientRepository.saveAllAndFlush(patientList);
		return patientList;
	}
	
	public Patient savePatients(Patient patient) {
		patientRepository.save(patient);
		return patient;
	}

	public List<Patient> findPatients() {
		return patientRepository.findAll();
	}
	
	public Patient findPatientsById(long id) {
		return patientRepository.findById(id).get();
	}
}
