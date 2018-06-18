package com.example.drools.service.implementation;

import com.example.drools.model.Ingredient;
import com.example.drools.repository.IngredientRepository;
import com.example.drools.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Momir on 17.06.2018.
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAll() {

        List<Ingredient> ingredients = this.ingredientRepository.findAll();

        if(ingredients != null)
            return ingredients;

        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {

        Ingredient ingredient1 = this.ingredientRepository.save(ingredient);

        return ingredient1;
    }
}
