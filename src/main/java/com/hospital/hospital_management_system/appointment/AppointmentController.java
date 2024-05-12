package com.hospital.hospital_management_system.appointment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital_management_system.global.GlobalResponseManager;

import jakarta.validation.Valid;

@RestController
@Validated
public class AppointmentController {

	private AppointmentService appointmentService;
	private GlobalResponseManager globalResponseManager;
	
	public AppointmentController(AppointmentService appointmentService, 
			GlobalResponseManager globalResponseManager) {
		super();
		this.appointmentService = appointmentService;
		this.globalResponseManager = globalResponseManager;
	}


	//Add New Appointment
	@PostMapping(path ="appointments")
	public ResponseEntity<Object> addAppointmentDetails(@Valid @RequestBody Appointment appointment) {
		appointmentService.saveAppointment(appointment);
		return globalResponseManager.successResponse(HttpStatus.CREATED, "SUCCESS", appointment);
	}
	
	//All Appointment List
	@GetMapping(path ="appointments")
	public ResponseEntity<Object> findAppointmentDetails() {
		List<Appointment> appointmentList = appointmentService.findAppointment();
		return globalResponseManager.successResponse(HttpStatus.OK, "SUCCESS", appointmentList);
	}
	
	//Get Appointment By Doctor ID
	@GetMapping(path ="appointments/doctors/{doctor_id}")
	public ResponseEntity<Object> findAppointmentDetailsByDoctorId(@PathVariable long doctor_id) {
		List<Appointment> appointmentList = appointmentService.findAppointmentByDoctor(doctor_id);
		return globalResponseManager.successResponse(HttpStatus.OK, "SUCCESS", appointmentList);
	}
	
	//Get Appointment By Patient Id
	@GetMapping(path ="appointments/patient/{patient_id}")
	public ResponseEntity<Object> findAppointmentDetailsBypatientId(@PathVariable long patient_id) {
		List<Appointment> appointmentList = appointmentService.findAppointmentByDoctor(patient_id);
		return globalResponseManager.successResponse(HttpStatus.OK, "SUCCESS", appointmentList);
	}
}
