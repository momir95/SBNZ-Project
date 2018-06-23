package com.example.drools.model;

import com.example.drools.payload.Diagnose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

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
public class Symptom implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true, nullable = false)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SymptomType symptomType;

    public Symptom(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symptom)) return false;

        Symptom symptom = (Symptom) o;

        if (!getName().equals(symptom.getName())) return false;
        return getSymptomType() == symptom.getSymptomType();
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSymptomType().hashCode();
        return result;
    }

    @Override
    public int compareTo(Object o) {

        SymptomType type =((Symptom)o).getSymptomType();

        if(type == SymptomType.GENERAL)
            return -1;
        else
            return 1;
    }
}
