package com.example.drools.service.implementation;

import com.example.drools.model.*;
import com.example.drools.repository.CureRepository;
import com.example.drools.repository.DiseaseRepository;
import com.example.drools.repository.MedicalRecordRepository;
import com.example.drools.repository.PatientRepository;
import com.example.drools.service.PatientService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Momir on 15.06.2018.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private CureRepository cureRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    private final KieContainer kieContainer;

    @Autowired
    public PatientServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @Override
    public Patient save(Patient patient) {

        Patient patient1 = this.patientRepository.save(patient);

        return patient1;
    }

    @Override
    public List<Patient> getPatientWithHronicalDisease() {

        KieSession kieSession = kieContainer.newKieSession();

        List<Patient> patients = this.patientRepository.findAll();
        List<Disease> diseases = this.diseaseRepository.findAll();
        List<MedicalRecord> medicalRecords = this.medicalRecordRepository.findAll();

        for(Patient patient: patients)
            kieSession.insert(patient);

        for(Disease disease: diseases)
            kieSession.insert(disease);

        for(MedicalRecord medicalRecord: medicalRecords)
            kieSession.insert(medicalRecord);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        kieSession.setGlobal("currentDate", now);


        Set<Patient> patientSet = new HashSet<>();

        QueryResults results = kieSession.getQueryResults( "Patients with hronical disease");

        for ( QueryResultsRow row : results ) {
            Patient patient = (Patient) row.get("$patient");
            patientSet.add(patient);
        }

        List<Patient> patientList = new ArrayList<>();
        for(Patient patient: patientSet)
            patientList.add(patient);

        return patientList;
    }

    @Override
    public List<Patient> getPatientWithAnalgeticCures() {

        KieSession kieSession = kieContainer.newKieSession();

        List<Patient> patients = this.patientRepository.findAll();
        List<Cure> cures = this.cureRepository.findAll();
        List<MedicalRecord> medicalRecords = this.medicalRecordRepository.findAll();

        for(Patient patient: patients)
            kieSession.insert(patient);

        for(Cure cure: cures)
            kieSession.insert(cure);

        for(MedicalRecord medicalRecord: medicalRecords)
            kieSession.insert(medicalRecord);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        kieSession.setGlobal("currentDate", now);


        List<Patient> patientList = new ArrayList<>();

        QueryResults results = kieSession.getQueryResults( "Patients with analgetic cures");

        for ( QueryResultsRow row : results ) {
            Patient patient = (Patient) row.get("$patient");
            patientList.add(patient);
        }

        return patientList;
    }

    @Override
    public List<Patient> getPatientWithWeakImunitet() {

        KieSession kieSession = kieContainer.newKieSession();

        List<Patient> patients = this.patientRepository.findAll();
        List<Cure> cures = this.cureRepository.findAll();
        List<MedicalRecord> medicalRecords = this.medicalRecordRepository.findAll();

        for(Patient patient: patients)
            kieSession.insert(patient);

        for(Cure cure: cures)
            kieSession.insert(cure);

        for(MedicalRecord medicalRecord: medicalRecords)
            kieSession.insert(medicalRecord);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        kieSession.setGlobal("currentDate", now);


        List<Patient> patientSet = new ArrayList<>();

        QueryResults results = kieSession.getQueryResults( "Patients with weak imunitet");

        for ( QueryResultsRow row : results ) {
            Patient patient = (Patient) row.get("$patient");
            patientSet.add(patient);
        }

        List<Patient> patientList = new ArrayList<>();
        for(Patient patient: patientSet)
            patientList.add(patient);

        return patientList;

    }


}
