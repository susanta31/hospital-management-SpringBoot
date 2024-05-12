package com.hospital.hospital_management_system.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	@Autowired 
	public AppointmentRepository appointmentRepository;
	
	public List<Appointment> saveAppointment(List<Appointment> appointmentList) {
		appointmentRepository.saveAllAndFlush(appointmentList);
		return appointmentList;
	}

	public Appointment saveAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		return appointment;
	}
	
	public List<Appointment> findAppointmentByDoctor(long doctor_id) {
		return appointmentRepository.findByDoctorId(doctor_id);
	}
	
	public List<Appointment> findAppointment() {
		return appointmentRepository.findAll();
	}
}
