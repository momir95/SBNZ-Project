package com.example.drools.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true, nullable = false)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private DiseaseGroup diseaseGroup;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "disease_symptoms",
            joinColumns = { @JoinColumn(name = "disease_id") },
            inverseJoinColumns = { @JoinColumn(name = "symptom_id") })
    private Set<Symptom> symptoms = new HashSet<>();

    @Override
    public String toString() {
        return "Disease{" +
                "symptoms=" + symptoms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disease)) return false;

        Disease disease = (Disease) o;

        if (!getId().equals(disease.getId())) return false;
        if (!getName().equals(disease.getName())) return false;
        if (getDiseaseGroup() != disease.getDiseaseGroup()) return false;
        return getSymptoms().equals(disease.getSymptoms());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDiseaseGroup().hashCode();
        result = 31 * result + getSymptoms().hashCode();
        return result;
    }
}
