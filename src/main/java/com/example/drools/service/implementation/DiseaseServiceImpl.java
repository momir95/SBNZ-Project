package com.example.drools.service.implementation;

import com.example.drools.model.Cure;
import com.example.drools.model.Disease;
import com.example.drools.model.Symptom;
import com.example.drools.repository.DiseaseRepository;
import com.example.drools.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Momir on 18.06.2018.
 */
@Service
public class DiseaseServiceImpl implements DiseaseService{

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public List<Disease> getAll() {

        List<Disease> diseases = this.diseaseRepository.findAll();

        if(diseases != null)
            return diseases;

        return null;
    }

    @Override
    public Disease save(Disease disease) {

        Disease disease1 = this.diseaseRepository.save(disease);

        if(disease1 != null)
            return disease1;
        return null;
    }
}
