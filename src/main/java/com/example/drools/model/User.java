package com.example.drools.model;


import javax.persistence.*;
import lombok.*;


/**
 * Created by Momir on 10.06.2018.
 */
@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id" , unique = true, nullable = false)
    private Integer id;

    private String username;

    private String password;
}
