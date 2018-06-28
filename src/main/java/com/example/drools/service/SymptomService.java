package com.example.drools.service;

import com.example.drools.model.Ingredient;
import com.example.drools.model.Symptom;

import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
public interface SymptomService {

    List<Symptom> getAll();
    Symptom save(Symptom symptom);

}
