package com.example.drools.repository;

import com.example.drools.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Momir on 12.06.2018.
 */
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

    @Query("SELECT mr from MedicalRecord mr  WHERE mr.lbo=:lbo")
    MedicalRecord findByLbo(@Param("lbo") String lbo);

    @Query("SELECT mr from MedicalRecord mr  WHERE mr.id=:id")
    MedicalRecord findById(@Param("id") Integer id);
}
