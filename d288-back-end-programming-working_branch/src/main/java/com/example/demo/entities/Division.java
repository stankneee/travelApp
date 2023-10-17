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
@Table(name="divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Division_ID")
    private Long id;

    // The name of the division
    @Column(name="Division")
    private String division_name;

    // The country associated with the division
    @ManyToOne
    @JoinColumn(name="Country_ID", nullable = false)
    private Country country;

    // The customers associated with the division (One-to-Many relationship with Customer)
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers ;

    // The creation date of the division
    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    // The last update date of the division
    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;
}
