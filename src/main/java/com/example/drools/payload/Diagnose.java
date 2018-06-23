package com.example.drools.payload;

import com.example.drools.model.Disease;
import com.example.drools.model.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Momir on 19.06.2018.
 */
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
public class Diagnose implements Comparable{

    private List<Disease> diseases = new ArrayList<>();

    private int nbrSymptoms;

    private Set<Symptom> symptoms = new HashSet<>();

    @Override
    public String toString() {
        return "Diagnose{" +
                "symptoms=" + symptoms +
                '}';
    }



    @Override
    public int compareTo(Object o) {

        int nbrSymptoms=((Diagnose)o).getNbrSymptoms();
        /* For Ascending order*/
        return nbrSymptoms - this.nbrSymptoms;
    }
}
