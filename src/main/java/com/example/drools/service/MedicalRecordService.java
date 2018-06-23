package com.example.drools.service;

import com.example.drools.model.Cure;
import com.example.drools.model.MedicalRecord;
import com.example.drools.payload.ValidateCures;

import java.util.List;

/**
 * Created by Momir on 12.06.2018.
 */
public interface MedicalRecordService {

    MedicalRecord getMedicalRecordByLbo(String lbo);

    MedicalRecord getMedicalRecordById(Integer id);

    MedicalRecord save(MedicalRecord medicalRecord);

    MedicalRecord updateCures(Integer id, List<Cure> cures);

    ValidateCures validateCures(Integer id, List<Cure> enteredCures);
}
