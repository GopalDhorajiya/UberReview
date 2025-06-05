package com.gopal.uberreviewservice.services;

import com.gopal.uberreviewservice.models.Booking;
import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReviewService implements CommandLineRunner {// this CommandLineRunner will give method run will automatically run when starts application

    private final ReviewRepository reviewRepository;


    public ReviewService(@Autowired ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running app");

    }
}
