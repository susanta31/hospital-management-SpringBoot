package com.hospital.hospital_management_system.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiaStateService {
	
	@Autowired
	public IndiaStateRepository indiaStateRepository;
	
	public boolean isValidState(String state) {
		
		IndiaState indiaState = indiaStateRepository.findByState(state);
		
		if (indiaState != null) {
			return true;
		}
		return false;
	}

}
