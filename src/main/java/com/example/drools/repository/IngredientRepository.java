package com.example.drools.repository;

import com.example.drools.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Momir on 17.06.2018.
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
}
