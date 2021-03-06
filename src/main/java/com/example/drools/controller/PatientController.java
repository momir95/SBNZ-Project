package com.example.drools.controller;

import com.example.drools.model.Disease;
import com.example.drools.model.MedicalRecord;
import com.example.drools.model.Patient;
import com.example.drools.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 15.06.2018.
 */
@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> save(@RequestBody Patient patient) throws ParseException {

        Patient patient1 = this.patientService.save(patient);

        if(patient1 == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getPatientWithHronicalDisease", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> getPatientWithHronicalDisease() throws ParseException {

        List<Patient> patients = this.patientService.getPatientWithHronicalDisease();

        if(patients == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPatientWithAnalgeticCures", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> getPatientWithAnalgeticCures() throws ParseException {

        List<Patient> patients = this.patientService.getPatientWithAnalgeticCures();

        if(patients == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPatientWithWeakImunitet", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> getPatientWithWeakImunitet() throws ParseException {

        List<Patient> patients = this.patientService.getPatientWithWeakImunitet();

        if(patients == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
