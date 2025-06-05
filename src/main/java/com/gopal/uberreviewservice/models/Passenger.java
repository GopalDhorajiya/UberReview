package com.gopal.uberreviewservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "passenger",fetch = FetchType.LAZY)
    private List<Booking> bookings;
}
