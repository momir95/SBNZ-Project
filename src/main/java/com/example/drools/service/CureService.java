package com.example.drools.service;

import com.example.drools.model.Cure;
import com.example.drools.model.MedicalRecord;

import java.util.List;

/**
 * Created by Momir on 14.06.2018.
 */
public interface CureService {

    List<Cure> getAllCures();
    Cure save(Cure cure);

}
