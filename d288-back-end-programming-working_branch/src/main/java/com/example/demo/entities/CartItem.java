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
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_Item_ID")
    private Long id;

    // The vacation associated with the cart item
    @ManyToOne
    @JoinColumn(name = "Vacation_ID")
    private Vacation vacation;

    // The excursions associated with the cart item (Many-to-Many relationship with Excursion)
    @ManyToMany(mappedBy = "cartItems")
    private Set<Excursion> excursions = new HashSet<>();

    // The cart associated with the cart item
    @ManyToOne
    @JoinColumn(name = "cart_ID")
    private Cart cart;

    // The creation date of the cart item
    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the cart item
    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date last_update;

    // Method to add an excursion to the cart item
    public void addExcursion(Excursion excursion) {
        this.excursions.add(excursion);
        excursion.getCartItems().add(this);
    }
}
