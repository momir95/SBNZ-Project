package com.example.drools.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Momir on 10.06.2018.
 */

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , unique = true, nullable = false)
    private Integer id;

    private String lbo; //licni broj osiguranika

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "medicalRecord")
    private Set<Review> reviews = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToMany(fetch = FetchType.EAGER
            ,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "medicalRecord_cures",
            joinColumns = { @JoinColumn(name = "medicalRecord_id") },
            inverseJoinColumns = { @JoinColumn(name = "cure_id") })
    private Set<Cure> cures = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "medicalRecord_ingredients",
            joinColumns = { @JoinColumn(name = "medicalRecord_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") })
    private Set<Ingredient> ingredients = new HashSet<>();
}
