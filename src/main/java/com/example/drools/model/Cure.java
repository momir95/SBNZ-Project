package com.example.drools.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Momir on 10.06.2018.
 */
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
public class Cure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true, nullable = false)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CureType cureType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cure_ingredients",
            joinColumns = { @JoinColumn(name = "cure_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") })
    private Set<Ingredient> ingredients = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cure)) return false;

        Cure cure = (Cure) o;

        if (!getId().equals(cure.getId())) return false;
        if (!getName().equals(cure.getName())) return false;
        if (getCureType() != cure.getCureType()) return false;
        return getIngredients().equals(cure.getIngredients());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCureType().hashCode();
        result = 31 * result + getIngredients().hashCode();
        return result;
    }
}
