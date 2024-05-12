package com.hospital.hospital_management_system.doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.hospital_management_system.appointment.Appointment;
import com.hospital.hospital_management_system.patient.Patient;
import com.hospital.hospital_management_system.utility.validaor.ListValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
	    name = "doctor",
	    indexes = {
	        @Index(name = "doctor_index", columnList = ("name, email, mobile, address.state"))
	    }
	)
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "doc_gen")
	@TableGenerator(name = "doc_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	private long id;

	@NotBlank(message ="{name.message}")
	private String name;

	@Email(message ="{email.message}")
	@Column(unique = true)
	private String email;

	@Size(min=10, max=10, message="{mobile.message}")
	@Column(unique = true)
	private String mobile;

	@ListValidator(queryClass = Arrays.class, list = { "Male", "Female", "Other"}, message="{gender.message}")
	private String gender;

	@Past(message="{dob.message}")
	private LocalDate dateOfBirth;

	
	@Embedded
	@Valid
	private Address address;

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDateTime;

	@CreationTimestamp
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

	@ManyToMany(mappedBy = "doctor")
	@JsonIgnore
	private Set<Patient> patient;

	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private Set<Appointment> appointment;

}
