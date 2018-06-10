package com.example.drools.repository;

import com.example.drools.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Momir on 10.06.2018.
 */
public interface SymptomRepository extends JpaRepository<Symptom, Integer> {

    @Query("SELECT symptom from Symptom symptom  WHERE symptom.id=:id")
    Symptom find(@Param("id") Integer id);
}
