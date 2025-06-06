package com.gopal.uberreviewservice.repositories;


import com.gopal.uberreviewservice.models.Booking;
import com.gopal.uberreviewservice.models.Review;
import jakarta.persistence.criteria.From;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Integer countAllByRatingLessThanEqual(Double rating);

    List<Review> findAllByRatingIsLessThanEqual(Double ratingIsLessThan);

    List<Review> findAllByCreatedAtBefore(Date createdAtBefore);

    @Query("SELECT r FROM Review r where r = (select b.review from Booking b where b.id = :bookingid)")
    Review findByBookingId(Long bookingid);
}
