package com.example.drools.service.implementation;

import com.example.drools.model.Cure;
import com.example.drools.model.MedicalRecord;
import com.example.drools.repository.MedicalRecordRepository;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {

        MedicalRecord medicalRecord1 = this.medicalRecordRepository.save(medicalRecord);

        return medicalRecord1;
    }

    @Override
    public MedicalRecord updateCures(Integer id, List<Cure> cures) {

        MedicalRecord medicalRecord = this.medicalRecordRepository.findById(id);

        for(Cure cure: cures)
            medicalRecord.getCures().add(cure);

        MedicalRecord medicalRecord1 = this.medicalRecordRepository.save(medicalRecord);

        return medicalRecord1;
    }
}
