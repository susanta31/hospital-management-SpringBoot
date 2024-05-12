package com.hospital.hospital_management_system.patient;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospital_management_system.doctor.Doctor;
import com.hospital.hospital_management_system.doctor.DoctorService;
import com.hospital.hospital_management_system.global.GlobalResponseManager;

import jakarta.validation.Valid;


@RestController
@Validated
public class PatientController {
	
	private PatientService patientService;
	private GlobalResponseManager globalResponseManager;
	
	public PatientController(PatientService patientService,
			GlobalResponseManager globalResponseManager) {
		super();
		this.patientService = patientService;
		this.globalResponseManager = globalResponseManager;
	}

	//Add New Patient Details (Single Add Or Batch Add)
	@PostMapping(path ="patients")
	public ResponseEntity<Object> addDoctorDetails(@Valid @RequestBody Patient patients) {
		patientService.savePatients(patients);
		return globalResponseManager.successResponse(HttpStatus.CREATED, "Patient record created successfully.", patients);
	}
	
	//View Patient Details
	@GetMapping(path ="patients")
	public ResponseEntity<Object> viewpatientDetails() {
		List<Patient> patients = patientService.findPatients();
		
		return globalResponseManager.successResponse(HttpStatus.OK, 
				+ patients.size() + " Patient record(s) were found successfully.", 
				patients);
	}
	
	//View By Id
	@GetMapping(path ="patients/{id}")
	public ResponseEntity<Object> viewPatientDetailsById(@PathVariable long id) {
		
		return globalResponseManager.successResponse(HttpStatus.OK, 
						"Patient record with id [" + id + "] successfully found.", 
						patientService.findPatientsById(id));
				
	}
}
