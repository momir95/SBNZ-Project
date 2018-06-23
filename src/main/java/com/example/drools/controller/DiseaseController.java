package com.example.drools.controller;

import com.example.drools.model.Cure;
import com.example.drools.model.Disease;
import com.example.drools.model.MedicalRecord;
import com.example.drools.model.Symptom;
import com.example.drools.service.DiseaseService;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disease>> getAll() throws ParseException {

        List<Disease> diseases = this.diseaseService.getAll();

        if(diseases == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(diseases, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disease> save(@RequestBody Disease disease) throws ParseException {

        Disease disease1 = this.diseaseService.save(disease);

        if(disease1 == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(disease1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/determineDisease/{mrId}", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disease>> determineDesease(@PathVariable("mrId") Integer mrId, @RequestBody List<Symptom> symptoms) throws ParseException {

        MedicalRecord medicalRecord = this.medicalRecordService.getMedicalRecordById(mrId);

        List<Disease> diseases = this.diseaseService.getPossibleDesease(medicalRecord, symptoms);

        if(diseases == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(diseases, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getDiseases", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disease>> getDiseases(@RequestBody List<Symptom> symptoms) throws ParseException {

        List<Disease> diseases = this.diseaseService.getDisease(symptoms);

        if(diseases == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(diseases, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getSymptoms", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Symptom>> getSymptoms(@RequestBody Disease disease) throws ParseException {

        System.out.println("Bolest: " + disease.getName());
        List<Symptom> symptoms = this.diseaseService.getSymptoms(disease);

        if(symptoms == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(symptoms, HttpStatus.OK);
    }
}
