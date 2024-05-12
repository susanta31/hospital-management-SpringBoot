package com.hospital.hospital_management_system.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	@Autowired 
	public DoctorRepository doctorRepository;
	
	public List<Doctor> saveDoctor(List<Doctor> doctorList) {
		doctorRepository.saveAllAndFlush(doctorList);
		return doctorList;
	}
	
	public Doctor saveDoctor(Doctor doctorList) {
		doctorRepository.save(doctorList);
		return doctorList;
	}

	public List<Doctor> findDoctors() {
		return doctorRepository.findAll();
	}
	
	public Doctor findDoctorsById(long id) {
		return doctorRepository.findById(id).get();
	}

}
