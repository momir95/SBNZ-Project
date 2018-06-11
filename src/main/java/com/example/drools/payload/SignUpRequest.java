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
