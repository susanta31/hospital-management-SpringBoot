package com.hospital.hospital_management_system.utility.validaor;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.hospital_management_system.utility.IndiaStateService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class CustomListValidator implements ConstraintValidator<ListValidator, String> {

	@Autowired
	private IndiaStateService indiaStateService;
	
    public CustomListValidator() {
    	super();
    }
    
	private Class<?> queryClass;
	private String[] list;

	@Override
	public void initialize(ListValidator annotation) {
		queryClass = annotation.queryClass();
		list = annotation.list();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (queryClass == IndiaStateService.class && indiaStateService != null)  {
			return indiaStateService.isValidState(value);	
		} else if (queryClass == Arrays.class) {
			return Arrays.asList(list).contains(value);
		} else {
			return true;
		}
	}

}
