package com.example.application.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime orderDate;
    private double totalAmount;
    private String address;
    private String status; // HAZIRLANIYOR, KARGODA, TESLIM EDILDI

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> items;

    // Getter, Setter, Constructor
    public Order() {}

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Set<OrderItem> getItems() { return items; }
} 