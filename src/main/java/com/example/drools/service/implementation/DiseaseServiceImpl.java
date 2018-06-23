package com.example.drools.service.implementation;

import com.example.drools.model.Disease;
import com.example.drools.model.MedicalRecord;
import com.example.drools.model.Symptom;
import com.example.drools.payload.Diagnose;
import com.example.drools.repository.DiseaseRepository;
import com.example.drools.repository.SymptomRepository;
import com.example.drools.service.DiseaseService;
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
 * Created by Momir on 18.06.2018.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService{

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private SymptomRepository symptomRepository;



    private final KieContainer kieContainer;

    @Autowired
    public DiseaseServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @Override
    public List<Disease> getAll() {

        List<Disease> diseases = this.diseaseRepository.findAll();

        if(diseases != null)
            return diseases;

        return null;
    }

    @Override
    public Disease save(Disease disease) {

        Disease disease1 = this.diseaseRepository.save(disease);

        if(disease1 != null)
            return disease1;
        return null;
    }

    @Override
    public List<Disease> getPossibleDesease(MedicalRecord medicalRecord, List<Symptom> symptoms) {

        KieSession kieSession = kieContainer.newKieSession();

        List<Disease> diseases = this.diseaseRepository.findAll();
        List<Symptom> symptoms1 = this.symptomRepository.findAll();


        for (Disease disease : diseases)
            kieSession.insert(disease);

        for (Symptom symptom : symptoms1)
            kieSession.insert(symptom);

        Diagnose diagnose = new Diagnose();
        diagnose.setNbrSymptoms(0);

        Set<Symptom> diagnoseSymptoms = new HashSet<>();

        for(Symptom symptom: symptoms)
            diagnoseSymptoms.add(symptom);

        diagnose.setSymptoms(diagnoseSymptoms);

        System.out.println("Izabrani simptomi");
        for(Symptom symptom: diagnose.getSymptoms())
        {
            System.out.println("Simptom: " + symptom.getName());

        }


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        kieSession.setGlobal("diagnose", diagnose);
        kieSession.setGlobal("currentDate", now);
        kieSession.insert(diagnose);

        kieSession.fireAllRules();

        diagnose = (Diagnose) kieSession.getGlobal("diagnose");




        return diagnose.getDiseases();
    }

    @Override
    public List<Disease> getDisease(List<Symptom> symptoms) {

        KieSession kieSession = kieContainer.newKieSession();

        List<Disease> diseases = this.diseaseRepository.findAll();


        for (Disease disease : diseases)
            kieSession.insert(disease);

        List<Disease> diseaseList = new ArrayList<>();
        List<Diagnose> diagnoses = new ArrayList<>();


        QueryResults results = kieSession.getQueryResults( "Get diseases which assosieted with symptoms", symptoms);

        for ( QueryResultsRow row : results ) {
            Disease disease = (Disease) row.get("$disease");
            Integer nbr = (Integer) row.get("rez");
            diagnoses.add(new Diagnose(Arrays.asList(disease), nbr,null));
        }



        Collections.sort(diagnoses);

        for(Diagnose diagnose: diagnoses)
            diseaseList.add(diagnose.getDiseases().get(0));


        return diseaseList;
    }

    @Override
    public List<Symptom> getSymptoms(Disease disease) {

        KieSession kieSession = kieContainer.newKieSession();

        List<Symptom> symptoms = this.symptomRepository.findAll();


        for (Symptom symptom : symptoms)
            kieSession.insert(symptom);

        List<Symptom> symptomsList = new ArrayList<>();



        QueryResults results = kieSession.getQueryResults( "Get symptoms", disease);

        for ( QueryResultsRow row : results ) {
            Symptom symptom = (Symptom) row.get("$symptom");
            symptomsList.add(symptom);
        }


        Collections.sort(symptomsList);

        return symptomsList;
    }
}
