package com.example.drools.controller;

import com.example.drools.model.*;
import com.example.drools.payload.ValidateCures;
import com.example.drools.repository.ReviewRepository;
import com.example.drools.repository.UserRepository;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 12.06.2018.
 */
@RestController
@RequestMapping("/api/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

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
        System.out.println("Broj lekova: " + medicalRecord.getCures().size());

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

    @RequestMapping(value = "/updateCures/{id}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
     ResponseEntity<MedicalRecord> updateCures(@PathVariable("id") Integer id, @RequestBody List<Cure> cures) throws ParseException {

        System.out.println("Update cures");
        MedicalRecord medicalRecord1 = this.medicalRecordService.updateCures(id, cures);

        if(medicalRecord1 == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(medicalRecord1, HttpStatus.OK);
    }

    @RequestMapping(value = "/validateCures/{mrId}", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValidateCures> validateCures(@PathVariable("mrId") Integer mrId, @RequestBody List<Cure> cures) throws ParseException {

        ValidateCures validateCures = this.medicalRecordService.validateCures(mrId, cures);

        System.out.println("Usao u validate");

        if(validateCures == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(validateCures, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addReview/{mrId}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<MedicalRecord> addReview(@PathVariable("mrId") Integer mrId, @RequestBody Review review) throws ParseException {

        User user = this.userRepository.findById(review.getDoctor().getId()).orElse(null);
        review.setDoctor(user);

        MedicalRecord medicalRecord = this.medicalRecordService.getMedicalRecordById(mrId);

        review.setMedicalRecord(medicalRecord);

        Review review1 = this.reviewRepository.save(review);

        medicalRecord.getReviews().add(review1);

        medicalRecord = this.medicalRecordService.save(medicalRecord);


        if(medicalRecord == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }
}
