package com.hospital.hospital_management_system.patient;

import com.hospital.hospital_management_system.utility.IndiaStateService;
import com.hospital.hospital_management_system.utility.validaor.ListValidator;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@NotBlank(message="{home.message}")
	private String home;
	
	@NotBlank( message="{street.message}")
	private String street;
	
	@ListValidator(queryClass = IndiaStateService.class, list = {},  message="{state.message}")
	private String state;

	@Min(value = 100000, message="{pincode.message}")
    @Max(value = 999999, message="{pincode.message}")
	private int pincode;
	
}
