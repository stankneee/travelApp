// Author: Stanton Barbadillo

// Import statements for necessary libraries and annotations
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_ID")
    private Long id;

    // The first name of the customer
    @Column(name="Customer_First_Name", nullable = false)
    private String firstName;

    // The last name of the customer
    @Column(name="Customer_Last_Name", nullable = false)
    private String lastName;

    // The address of the customer
    @Column(name="Address", nullable = false)
    private String address;

    // The postal code of the customer
    @Column(name="Postal_Code")
    private String postal_code;

    // The phone number of the customer
    @Column(name="Phone", nullable = false)
    private String phone;

    // The creation date of the customer
    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the customer
    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

    // The division associated with the customer
    @ManyToOne
    @JoinColumn(name="Division_ID")
    private Division division;

    // The carts associated with the customer (One-to-Many relationship with Cart)
    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    // Method to add a cart to the customer
    public void add(Cart cart) {
        if(cart != null){
            if(carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }

    // Constructor to create a customer with specified attributes
    public Customer(String firstName, String lastName, String address, String postal_code, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
    }

    // Default constructor
    public Customer() {
    }
}
