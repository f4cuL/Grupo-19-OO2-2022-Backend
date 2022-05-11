package com.trabajopractico.sistema.entities.pojo;

public class JWTResponse {
    private String jwtToken;

    public JWTResponse() {
    }

    public JWTResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public JWTResponse jwtToken(String jwtToken) {
        setJwtToken(jwtToken);
        return this;
    }





}
