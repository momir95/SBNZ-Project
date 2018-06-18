package com.example.drools.service;

import com.example.drools.model.Cure;
import com.example.drools.model.Disease;

import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
public interface DiseaseService {

    List<Disease> getAll();
    Disease save(Disease disease);


}
