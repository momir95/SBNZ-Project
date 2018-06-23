package com.example.drools.service;

import com.example.drools.model.Patient;

import java.util.List;

/**
 * Created by Momir on 15.06.2018.
 */
public interface PatientService {

    Patient save(Patient patient);
    List<Patient> getPatientWithHronicalDisease();
    List<Patient> getPatientWithAnalgeticCures();
    List<Patient> getPatientWithWeakImunitet();

}
