package com.example.drools.service;

import com.example.drools.model.Cure;
import com.example.drools.model.Ingredient;

import java.util.List;

/**
 * Created by Momir on 17.06.2018.
 */
public interface IngredientService {

    List<Ingredient> getAll();
    Ingredient save(Ingredient ingredient);

}
