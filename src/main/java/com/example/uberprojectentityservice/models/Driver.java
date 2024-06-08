package com.example.uberprojectentityservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends BaseModel   {
    private String name;

    @Column(nullable = false,unique = true)
    private String lisenceNumber;

    private String phoneNumber;

    private String address;

    private String aadharCard;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @OneToOne
    private ExactLocation exactLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.00")
    @DecimalMin(value = "0.01",message = "Rating must be greater than or equal to 0.01")
    private Double rating;

    private boolean isAvailable;

    //1:n , driver: Booking
    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();
}
