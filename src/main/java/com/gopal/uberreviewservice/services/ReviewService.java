package com.gopal.uberreviewservice.services;

import com.gopal.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<Review> findReviewbyId(Long review_id);

    List<Review> findAllReview();

    boolean deleteReviewById(Long review_id);
}
