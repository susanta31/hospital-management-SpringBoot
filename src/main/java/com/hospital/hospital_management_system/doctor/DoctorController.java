package com.hospital.hospital_management_system.doctor;

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
public class DoctorController {
	
	private DoctorService doctorService;
	private GlobalResponseManager globalResponseManager;
	
	public DoctorController(DoctorService doctorService, 
			GlobalResponseManager globalResponseManager) {
		super();
		this.doctorService = doctorService;
		this.globalResponseManager = globalResponseManager;
	}


	//Add New Doctor Details (Single Add Or Batch Add)
	@PostMapping(path ="doctors")
	public ResponseEntity<Object> addDoctorDetails(@Valid @RequestBody Doctor doctors) {
		doctorService.saveDoctor(doctors);
		return globalResponseManager.successResponse(HttpStatus.CREATED, "Doctor record created successfully.", doctors);
	}
	
	//View Doctor Details
	@GetMapping(path ="doctors")
	public ResponseEntity<Object> viewDoctorDetails() {
		List<Doctor> doctor = doctorService.findDoctors();
		
		return globalResponseManager.successResponse(HttpStatus.OK, 
				+ doctor.size() + " Doctor record(s) were found successfully.", 
				doctor);
	}
	
	//View By Id
	@GetMapping(path ="doctors/{id}")
	public ResponseEntity<Object> viewDoctorDetailsById(@PathVariable long id) {
		
		return globalResponseManager.successResponse(HttpStatus.OK, 
						"Doctor record with id [" + id + "] successfully found.", 
						doctorService.findDoctorsById(id));
				
	}

}
