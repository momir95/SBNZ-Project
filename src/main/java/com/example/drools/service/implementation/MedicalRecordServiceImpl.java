package com.example.drools.service.implementation;

import com.example.drools.model.MedicalRecord;
import com.example.drools.repository.MedicalRecordRepository;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Momir on 12.06.2018.
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord getMedicalRecordByLbo(String lbo) {

        MedicalRecord medicalRecord = this.medicalRecordRepository.findByLbo(lbo);

        if(medicalRecord != null)
            return medicalRecord;
        else
            return null;
    }

    @Override
    public MedicalRecord getMedicalRecordById(Integer id) {

        MedicalRecord medicalRecord = this.medicalRecordRepository.findById(id);

        if(medicalRecord != null)
            return medicalRecord;
        else
            return null;
    }
}
