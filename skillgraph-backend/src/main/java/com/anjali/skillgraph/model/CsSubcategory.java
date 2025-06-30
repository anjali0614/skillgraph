package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cs_subcategories")
public class CsSubcategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String subcategory;

    public CsSubcategory() {
    }

    public CsSubcategory(Long id, String category, String subcategory) {
        this.id = id;
        this.category = category;
        this.subcategory = subcategory;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}

