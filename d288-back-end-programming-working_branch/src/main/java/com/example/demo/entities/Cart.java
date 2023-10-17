// Import statements for necessary libraries and annotations
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// Author: Stanton Barbadillo

// Entity class definition for the "Cart" entity
@Entity
@Table(name = "carts")
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_ID")
    private Long id;

    // A unique identifier for the order
    @Column(name = "Order_Tracking_Number")
    private String orderTrackingNumber;

    // The price of the package associated with the cart
    @Column(name = "Package_Price")
    private BigDecimal package_price;

    // The size of the party associated with the cart
    @Column(name = "Party_Size")
    private int party_size;

    // The status of the cart (e.g., ordered, shipped)
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    // The customer associated with the cart
    @ManyToOne
    @JoinColumn(name = "customer_ID")
    private Customer customer;

    // The items within the cart (One-to-Many relationship with CartItem)
    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    // The creation date of the cart
    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the cart
    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date last_update;

    // Method to add a CartItem to the cart
    public void add(CartItem item) {
        if(item != null) {
            if(cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }
}
