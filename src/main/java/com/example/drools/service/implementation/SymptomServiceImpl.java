package com.example.drools.service.implementation;

import com.example.drools.model.Ingredient;
import com.example.drools.model.Symptom;
import com.example.drools.repository.SymptomRepository;
import com.example.drools.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
@Service
public class SymptomServiceImpl implements SymptomService{

    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public List<Symptom> getAll() {

        List<Symptom> symptoms = this.symptomRepository.findAll();

        if(symptoms != null)
            return symptoms;

        return null;
    }
}
