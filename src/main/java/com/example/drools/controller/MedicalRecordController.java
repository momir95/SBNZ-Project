package com.example.drools.controller;

import com.example.drools.model.MedicalRecord;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by Momir on 12.06.2018.
 */
@RestController
@RequestMapping("/api/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @RequestMapping(value = "/getByNumber/{lbo}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalRecord> getByNumber(@PathVariable("lbo") String lbo) throws ParseException {
        System.out.println("LBO: " + lbo);
        MedicalRecord medicalRecord = this.medicalRecordService.getMedicalRecordByLbo(lbo);

        if(medicalRecord == null)
        {
            System.out.println("Not found MR");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        System.out.println("Fistname: " + medicalRecord.getPatient().getFirstname());
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalRecord> getById(@PathVariable("id") Integer id) throws ParseException {

        MedicalRecord medicalRecord = this.medicalRecordService.getMedicalRecordById(id);

        if(medicalRecord == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalRecord> save(@RequestBody MedicalRecord medicalRecord) throws ParseException {

        MedicalRecord medicalRecord1 = this.medicalRecordService.save(medicalRecord);

        if(medicalRecord1 == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(medicalRecord1, HttpStatus.CREATED);
    }
}
