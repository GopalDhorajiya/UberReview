package com.gopal.uberreviewservice.adepters;

import com.gopal.uberreviewservice.Dtos.CreateReviewDto;
import com.gopal.uberreviewservice.Dtos.ReviewDto;
import com.gopal.uberreviewservice.models.Booking;
import com.gopal.uberreviewservice.models.Review;
import com.gopal.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewDtoToReviewAdepterImpl implements ReviewDtoToReviewAdepter{


    private final BookingRepository bookingRepository;

    public ReviewDtoToReviewAdepterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {

        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBooking_Id());
        return booking.map(value -> Review.builder().content(createReviewDto.getContent())
                .rating(createReviewDto.getRating())
                .booking(value)
                .build()).orElse(null);
    }

    @Override
    public ReviewDto convertReviewToDto(Review review) {
        return ReviewDto.builder().rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .Booking_id(review.getBooking().getId())
                .id(review.getId())
                .build();
    }
}
