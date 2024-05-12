package com.hospital.hospital_management_system.utility;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndiaState {
	
	@Id
	private int id;
	
	private String state;
	
}
