package com.hospital.hospital_management_system.utility;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IndiaStateRepository extends JpaRepository<IndiaState, Integer>{

	public IndiaState findByState(String state);

}
