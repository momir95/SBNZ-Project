package com.example.drools.service.implementation;

import com.example.drools.model.Cure;
import com.example.drools.model.Ingredient;
import com.example.drools.model.MedicalRecord;
import com.example.drools.payload.AllergicCures;
import com.example.drools.payload.ValidateCures;
import com.example.drools.repository.MedicalRecordRepository;
import com.example.drools.service.MedicalRecordService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Momir on 12.06.2018.
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    private final KieContainer kieContainer;

    @Autowired
    public MedicalRecordServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


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

    @Override
    public ValidateCures validateCures(Integer id, List<Cure> enteredCures) {

        KieSession kieSession = kieContainer.newKieSession();



        MedicalRecord medicalRecord = this.medicalRecordRepository.findById(id);

        AllergicCures allergicCures = new AllergicCures();

        allergicCures.setEnteredCures(enteredCures);

        for(Cure cure: enteredCures)
        {
            for(Ingredient ingredient: cure.getIngredients())
            {
                allergicCures.getEnteredIngredients().add(ingredient);
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        kieSession.setGlobal("currentDate", now);


        kieSession.setGlobal("allergicCures", allergicCures);
        kieSession.setGlobal("idMR", medicalRecord.getId());
        kieSession.insert(medicalRecord);

        kieSession.getAgenda().getAgendaGroup("validation").setFocus();
        kieSession.fireAllRules();

        allergicCures = (AllergicCures) kieSession.getGlobal("allergicCures");


        ValidateCures validateCures = new ValidateCures(allergicCures.getAllergicCures(), allergicCures.getAllergicIngredients());

        return validateCures;
    }
}
