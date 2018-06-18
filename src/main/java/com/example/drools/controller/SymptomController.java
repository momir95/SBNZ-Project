package com.example.drools.controller;

import com.example.drools.model.Ingredient;
import com.example.drools.model.Symptom;
import com.example.drools.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
@RestController
@RequestMapping("/api/symptom")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Symptom>> getAll() throws ParseException {

        List<Symptom> symptoms = this.symptomService.getAll();

        if(symptoms == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(symptoms, HttpStatus.OK);
    }
}
