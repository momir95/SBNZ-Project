package com.example.drools.payload;

/**
 * Created by Momir on 11.06.2018.
 */

import javax.validation.constraints.*;

public class SignUpRequest {

    @Size(min = 3, max = 15)
    private String username;


    @Size(min = 6, max = 20)
    private String password;

    private String firstname;

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
