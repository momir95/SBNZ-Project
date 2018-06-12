package com.example.drools.payload;

import com.example.drools.model.RoleName;

/**
 * Created by Momir on 11.06.2018.
 */
public class JwtAuthenticationResponse {
    private String token;
    private Integer id;
    private String username;
    private RoleName role;

    public JwtAuthenticationResponse(String accessToken, Integer id, String username, RoleName role) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public RoleName getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
