package com.example.drools.service;

import com.example.drools.model.Disease;
import com.example.drools.model.MedicalRecord;
import com.example.drools.model.Symptom;

import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
public interface DiseaseService {

    List<Disease> getAll();
    Disease save(Disease disease);
    List<Disease> getPossibleDesease(MedicalRecord medicalRecord, List<Symptom> symptoms);
    List<Disease> getDisease(List<Symptom> symptoms);
    List<Symptom> getSymptoms(Disease disease);


}
