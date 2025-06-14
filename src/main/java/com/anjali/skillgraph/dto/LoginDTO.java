package com.anjali.skillgraph.dto;

public class LoginDTO {
    private String identifier;
    private String password;

    public LoginDTO() {}

    public LoginDTO(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    // Getters
    public String getIdentifier() {
        return identifier;
    }


    public String getPassword() {
        return password;
    }

    // Setters
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
