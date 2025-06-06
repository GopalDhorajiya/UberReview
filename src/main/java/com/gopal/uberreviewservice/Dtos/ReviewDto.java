package com.gopal.uberreviewservice.Dtos;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReviewDto {
    private String content;;
    private Long id;
    private Double rating;
    private Date createdAt;
    private Date updatedAt;
    private Long Booking_id;
}
