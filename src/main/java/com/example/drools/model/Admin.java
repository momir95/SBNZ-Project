package com.example.drools.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Created by Momir on 10.06.2018.
 */

@Entity
@AllArgsConstructor(suppressConstructorProperties = true)
@Getter
@Setter
public class Admin extends User{


}
