package com. anjali.skillgraph.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String fullName;
    // @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;
    private String password;

    private String leetcodeId;
    private String gfgId;
    private String codeforcesId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills){
        this.skills = skills;
    }

    // Default constructor
    public User() {}

    // Constructor with all fields
    public User(String username, String fullName, String email, String password,  String leetcodeId, String gfgId, String codeforcesId) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.leetcodeId = leetcodeId;
        this.gfgId = gfgId;
        this.codeforcesId = codeforcesId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) {this.username = username;}

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLeetcodeId() { return leetcodeId; }
    public void setLeetcodeId(String leetcodeId) { this.leetcodeId = leetcodeId; }

    public String getGfgId() { return gfgId; }
    public void setGfgId(String gfgId) { this.gfgId = gfgId; }

    public String getCodeforcesId() { return codeforcesId; }
    public void setCodeforcesId(String codeforcesId) { this.codeforcesId = codeforcesId; }
}

