package com.gopal.uberreviewservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends BaseModel{
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)   //  Lazy fetch will not attach booking lists at Driver object creation time then if needed then call query and give it
    @Fetch(FetchMode.SUBSELECT)  // query will run for only one time
    private List<Booking> bookings = new ArrayList<>();

    private String address;
}
