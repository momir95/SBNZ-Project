package com.example.drools.controller;

import com.example.drools.model.Cure;
import com.example.drools.model.MedicalRecord;
import com.example.drools.service.CureService;
import com.example.drools.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 14.06.2018.
 */
@RestController
@RequestMapping("/api/cure")
public class CureController {

    @Autowired
    private CureService cureService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cure>> getAll() throws ParseException {

        List<Cure> cures = this.cureService.getAllCures();
        System.out.println("Numer of cures: " + cures.size());

        if(cures == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(cures, HttpStatus.OK);
    }
}
