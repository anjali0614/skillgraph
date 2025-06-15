package com.anjali.skillgraph.dto;

public class SkillDTO {
    private Long id;
    private String name;
    private String description;
    private int proficiency;

    public SkillDTO() {}

    public SkillDTO(Long id, String name, String description, int proficiency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.proficiency = proficiency;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}

