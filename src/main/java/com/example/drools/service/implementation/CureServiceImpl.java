package com.example.drools.service.implementation;

import com.example.drools.model.Cure;
import com.example.drools.model.MedicalRecord;
import com.example.drools.repository.CureRepository;
import com.example.drools.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Momir on 14.06.2018.
 */
@Service
public class CureServiceImpl implements CureService {

    @Autowired
    private CureRepository cureRepository;

    @Override
    public List<Cure> getAllCures() {

        List<Cure> cures = this.cureRepository.findAll();

        if(cures != null)
            return cures;
        else
            return null;
    }
}
