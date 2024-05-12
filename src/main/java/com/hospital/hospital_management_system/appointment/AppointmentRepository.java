package com.hospital.hospital_management_system.appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findByDoctorId(long doctorId);

	List<Appointment> findByPatientId(long patient_id);

}
