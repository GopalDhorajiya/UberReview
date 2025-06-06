package com.gopal.uberreviewservice.Controller;


import com.gopal.uberreviewservice.Dtos.CreateReviewDto;
import com.gopal.uberreviewservice.adepters.ReviewDtoToReviewAdepter;
import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDto createReviewDto) {
        System.out.println(createReviewDto);
        Review coming = reviewDtoToReviewAdepter.convertDto(createReviewDto);
        if(coming == null)
        {
            return new ResponseEntity<>("Not Found Booking",HttpStatus.BAD_REQUEST);
        }
        coming = reviewService.creatReview(coming);
        return new ResponseEntity<>(coming, HttpStatus.CREATED);
    }

}