package com.gopal.uberreviewservice.Controller;


import com.gopal.uberreviewservice.Dtos.CreateReviewDto;
import com.gopal.uberreviewservice.Dtos.ReviewDto;
import com.gopal.uberreviewservice.adepters.ReviewDtoToReviewAdepter;
import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uber/v1/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewDtoToReviewAdepter reviewDtoToReviewAdepter;


    public ReviewController(@Autowired ReviewService reviewService, ReviewDtoToReviewAdepter reviewDtoToReviewAdepter) {
        this.reviewService = reviewService;
        this.reviewDtoToReviewAdepter = reviewDtoToReviewAdepter;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllReview()
    {
        List<Review> reviews = reviewService.getAllReview();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for(Review review : reviews)
        {
            reviewDtos.add(reviewDtoToReviewAdepter.convertReviewToDto(review));
        }
        return new ResponseEntity<>(reviewDtos,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id)
    {
        try
        {
            Optional<Review> review = reviewService.findReviewbyId(id);
            if(review.isEmpty())
            {
                return new ResponseEntity<>("Not found is review",HttpStatus.BAD_REQUEST);
            }
            else
            {
                ReviewDto reviewDto = reviewDtoToReviewAdepter.convertReviewToDto(review.get());
                return new ResponseEntity<>(reviewDto,HttpStatus.FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDto createReviewDto) {
        System.out.println(createReviewDto);
        Review coming = reviewDtoToReviewAdepter.convertDto(createReviewDto);
        if(coming == null)
        {
            return new ResponseEntity<>("Not Found Booking",HttpStatus.BAD_REQUEST);
        }
        coming = reviewService.creatReview(coming);
        ReviewDto reviewDto = reviewDtoToReviewAdepter.convertReviewToDto(coming);
        return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
    }

}