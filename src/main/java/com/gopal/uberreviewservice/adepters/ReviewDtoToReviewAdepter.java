package com.gopal.uberreviewservice.adepters;

import com.gopal.uberreviewservice.Dtos.CreateReviewDto;
import com.gopal.uberreviewservice.models.Review;

public interface ReviewDtoToReviewAdepter {
    Review convertDto(CreateReviewDto createReviewDto);
}
