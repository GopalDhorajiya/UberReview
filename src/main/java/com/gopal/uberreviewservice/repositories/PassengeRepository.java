package com.gopal.uberreviewservice.repositories;


import com.gopal.uberreviewservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengeRepository extends JpaRepository<Passenger,Long> {
}
