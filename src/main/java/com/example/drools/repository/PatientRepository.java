package com.example.drools.repository;

import com.example.drools.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Momir on 15.06.2018.
 */
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
