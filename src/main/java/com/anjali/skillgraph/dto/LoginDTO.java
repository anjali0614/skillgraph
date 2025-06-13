package com.anjali.skillgraph.dto;

public class LoginDTO {
    private String Username;
    private String password;

    public LoginDTO() {}

    public LoginDTO(String username, String password) {
        this.Username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.Username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
