package com.gopal.uberreviewservice.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateReviewDto {
    private Double rating;

    private String content;

    private Long Booking_Id;
}
