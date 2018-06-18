package com.example.drools.repository;

import com.example.drools.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Momir on 18.06.2018.
 */
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

}
