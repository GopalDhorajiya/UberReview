package com.gopal.uberreviewservice.repositories;

import com.gopal.uberreviewservice.models.Booking;
import com.gopal.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {


}
