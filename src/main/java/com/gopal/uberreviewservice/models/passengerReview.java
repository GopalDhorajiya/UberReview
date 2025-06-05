package com.gopal.uberreviewservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class passengerReview extends Review{

    String passengerReviewContent;

    @Column(nullable = false)
    String passengerRating;
}
