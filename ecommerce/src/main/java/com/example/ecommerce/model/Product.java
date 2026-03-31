package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;

    // Getters & Setters
    public int getId() { return Math.toIntExact(id); }
    public void setId(int id) { this.id = (long) id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


        // ... your existing fields (id, name, price, description)

        private String imageUrl; // Add this line

        // Add Getter and Setter
        public String getImageUrl() { return imageUrl; }
        public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

}
