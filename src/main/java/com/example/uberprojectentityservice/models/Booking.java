package com.example.uberprojectentityservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity //Entity annotation defines that a class can be mapped to a table
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(indexes = {
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModel{

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Enumerated(value= EnumType.STRING)
    BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @OneToOne
    private ExactLocation startLocation;

    @OneToOne
    private ExactLocation endLocation;
}
