package com.example.drools.payload;

import com.example.drools.model.Cure;
import com.example.drools.model.Disease;
import com.example.drools.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Momir on 20.06.2018.
 */
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
public class AllergicCures {

    private List<Cure> enteredCures = new ArrayList<>();

    private Set<Ingredient> enteredIngredients = new HashSet<>();

    private List<Cure> allergicCures = new ArrayList<>();

    private List<Ingredient> allergicIngredients = new ArrayList<>();


}
