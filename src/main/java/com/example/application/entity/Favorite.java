package com.example.application.entity;

import com.example.application.entity.Product;

import jakarta.persistence.*;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getter, Setter, Constructor
    public Favorite() {}

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
} 