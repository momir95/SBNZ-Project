package com.example.drools.controller;

import com.example.drools.model.Cure;
import com.example.drools.model.Disease;
import com.example.drools.service.DiseaseService;
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
 * Created by Momir on 18.06.2018.
 */
@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

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
}
