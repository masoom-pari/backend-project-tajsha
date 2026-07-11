package com.tajsha.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // category hata kar ye likhein
    private Double price;
    private Double rating;      // ye naya field add karein

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Vendor() {}

    // Getters aur Setters
    public Long getId() { return id; }
//    public void setId(Double id) { this.id = ; }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}