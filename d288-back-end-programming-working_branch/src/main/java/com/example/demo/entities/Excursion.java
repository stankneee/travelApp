// Author: Stanton Barbadillo

// Import statements for necessary libraries and annotations
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="excursions")
@Data
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Excursion_ID")
    private Long id;

    // The title of the excursion
    @Column(name="Excursion_Title")
    private String excursion_title;

    // The price of the excursion
    @Column(name="Excursion_Price")
    private BigDecimal excursion_price;

    // The URL of the excursion's image
    @Column(name="Image_URL")
    private String image_URL;

    // The creation date of the excursion
    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the excursion
    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

    // The vacation associated with the excursion
    @ManyToOne
    @JoinColumn(name="Vacation_ID", nullable = false)
    private Vacation vacation;

    // The cart items associated with the excursion (Many-to-Many relationship with CartItem)
    @ManyToMany
    @JoinTable(name="excursion_cartitem",
            joinColumns=@JoinColumn(name="excursion_id"),
            inverseJoinColumns=@JoinColumn(name="cart_item_id"))
    private Set<CartItem> cartItems = new HashSet<>();
}
