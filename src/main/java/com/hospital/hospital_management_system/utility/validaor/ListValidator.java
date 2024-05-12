package com.hospital.hospital_management_system.utility.validaor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomListValidator.class) // Specify as array
public @interface ListValidator {
	
	String message() default "Invalid data";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	Class<?> queryClass(); // Class parameter
    String[] list() default { }; // Object parameter
   
}
