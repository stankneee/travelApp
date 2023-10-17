// Author: Stanton Barbadillo

// Import statements for necessary libraries and annotations
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Country_ID")
    private Long id;

    // The name of the country
    @Column(name="country")
    private String country_name;

    // The divisions (subdivisions) associated with the country
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions ;

    // The creation date of the country
    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the country
    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;
}
