package com.example.drools.controller;

import com.example.drools.model.Cure;
import com.example.drools.model.Ingredient;
import com.example.drools.model.MedicalRecord;
import com.example.drools.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Momir on 17.06.2018.
 */
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> getAll() throws ParseException {

        List<Ingredient> ingredients = this.ingredientService.getAll();

        if(ingredients == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ingredient>> save(@RequestBody List<Ingredient> ingredients) throws ParseException {

        Boolean saved = true;
        for(Ingredient ingredient: ingredients) {
            Ingredient ingredient1 = this.ingredientService.save(ingredient);
            if(ingredient1 == null)
                saved = false;
        }

        if(saved == false)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(ingredients, HttpStatus.CREATED);
    }
}
