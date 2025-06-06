package com.gopal.uberreviewservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.MultipleDocumentHandling;
import java.util.Date;
import java.util.List;

@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"review"})
public class Booking extends BaseModel{

    @OneToOne(mappedBy = "booking")
    @JsonManagedReference
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
