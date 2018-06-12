package com.example.drools.service;

import com.example.drools.model.MedicalRecord;

/**
 * Created by Momir on 12.06.2018.
 */
public interface MedicalRecordService {

    MedicalRecord getMedicalRecordByLbo(String lbo);

    MedicalRecord getMedicalRecordById(Integer id);
}
