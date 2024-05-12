package com.hospital.hospital_management_system.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long>  {

}
