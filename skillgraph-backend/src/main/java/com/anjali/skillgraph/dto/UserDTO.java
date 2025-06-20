package com.anjali.skillgraph.dto;

import java.util.List;
import com.anjali.skillgraph.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String username;// ✅ Add this
    private String password;

    private String leetcodeId;
    private String gfgId;
    private String codeforcesId;

    private List<SkillDTO> skills;// ✅ Add this

    // Default constructor
    public UserDTO() {}

    // Constructor for returning saved user info
    public UserDTO(Long id, String username, String email, String leetcodeId, String gfgId, String codeforcesId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.leetcodeId = leetcodeId;
        this.gfgId = gfgId;
        this.codeforcesId = codeforcesId;
    }


    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFullName(user.getFullName()); // ✅ Corrected
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setLeetcodeId(user.getLeetcodeId());
        dto.setGfgId(user.getGfgId());
        dto.setCodeforcesId(user.getCodeforcesId());
        return dto;
    }


    // All Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getLeetcodeId() { return leetcodeId; }
    public void setLeetcodeId(String leetcodeId) { this.leetcodeId = leetcodeId; }

    public String getGfgId() { return gfgId; }
    public void setGfgId(String gfgId) { this.gfgId = gfgId; }

    public String getCodeforcesId() { return codeforcesId; }
    public void setCodeforcesId(String codeforcesId) { this.codeforcesId = codeforcesId; }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }
}

