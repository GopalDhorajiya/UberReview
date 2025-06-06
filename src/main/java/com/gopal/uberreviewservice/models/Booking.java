package com.gopal.uberreviewservice.models;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Booking extends BaseModel{

    @OneToOne(mappedBy = "booking")
    private Review review;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")// store as a String Default is int
    BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

}
