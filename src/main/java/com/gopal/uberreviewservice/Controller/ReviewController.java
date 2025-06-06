package com.gopal.uberreviewservice.Controller;


import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.repositories.BookingRepository;
import com.gopal.uberreviewservice.repositories.ReviewRepository;
import com.gopal.uberreviewservice.services.ReviewService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uber/v1/review")
public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(@Autowired ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllReview()
    {
        return ResponseEntity.ok(reviewService.getAllReview());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.ok(reviewService.findReviewbyId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review saved = reviewService.creatReview(review);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}