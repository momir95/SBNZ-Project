package com.example.drools.service.implementation;

import com.example.drools.model.Patient;
import com.example.drools.repository.PatientRepository;
import com.example.drools.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Momir on 15.06.2018.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {

        Patient patient1 = this.patientRepository.save(patient);

        return patient1;
    }
}
