package com.gopal.uberreviewservice.services;

import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService {// this CommandLineRunner will give method run will automatically run when starts application

    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(@Autowired ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewbyId(Long review_id) {
        return reviewRepository.findById(review_id);
    }

    @Override
    @Transactional // Ensure this method runs within a transaction
    public Review creatReview(Review reviewData) {
        return reviewRepository.save(reviewData);
    }


    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long review_id) {
        try
        {
            reviewRepository.deleteById(review_id);
            return true;
        }
        catch (Exception e)
        {
            return false;

        }
    }

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }


}
