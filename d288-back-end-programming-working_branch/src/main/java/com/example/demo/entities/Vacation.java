// Author: Stanton Barbadillo

// Import statements for necessary libraries and annotations
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Vacation_ID")
    private Long id;

    // The title of the vacation
    @Column(name="Vacation_Title")
    private String vacation_title;

    // The description of the vacation
    @Column(name="Description")
    private String description;

    // The price of the travel fare associated with the vacation
    @Column(name="Travel_Fare_Price")
    private BigDecimal travel_price;

    // The URL of the vacation's image
    @Column(name="Image_URL")
    private String image_URL;

    // The creation date of the vacation
    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the vacation
    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

    // The excursions associated with the vacation (One-to-Many relationship with Excursion)
    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;
}
