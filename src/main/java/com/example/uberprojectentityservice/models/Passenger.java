package com.example.uberprojectentityservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class    Passenger extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy="passenger")
    private List<Booking> bookings= new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.00")
    @DecimalMin(value = "0.01",message = "Rating must be greater than or equal to 0.01")
    private Double rating;

    @OneToOne
    private ExactLocation exactLocation;

    @OneToOne
    private ExactLocation home;

}

