package com.hospital.hospital_management_system.appointment;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hospital.hospital_management_system.doctor.Doctor;
import com.hospital.hospital_management_system.patient.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "app_gen")
	@TableGenerator(name = "app_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	private long id;

	@FutureOrPresent(message="{appointmentTime.message}")
	private LocalDateTime appointmentTime;

	
	private String rxDetails;

	private LocalDateTime checkInTime;

	
	private LocalDateTime checkOutTime;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createDateTime;

	/*
	 * Mapping Part Patient -> Doctor (ManyToMany) (Bidirectional)
	 * ----------
	 * Patient -> Appointment (OneToMany) (Unidirectional)
	 * Appointment -> Patient (ManyToOne)
	 * ----------
	 * Doctor -> Appointment (OneToMany) (Unidirectional)
	 * Appointment -> Doctor (ManyToOne)
	 */

	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;

}
