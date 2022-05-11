package com.trabajopractico.sistema.entities.pojo;

public class JWTRequest {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public JWTRequest() {
    }

    public JWTRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

