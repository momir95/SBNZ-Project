package com.example.drools.payload;

import com.example.drools.model.Cure;
import com.example.drools.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Momir on 21.06.2018.
 */
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
public class ValidateCures {

    private List<Cure> allergicCures = new ArrayList<>();

    private List<Ingredient> allergicIngredients = new ArrayList<>();
}
