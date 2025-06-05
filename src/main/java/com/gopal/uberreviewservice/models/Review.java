package com.gopal.uberreviewservice.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    private String content;

    @Column(nullable = false)
    private Double rating;

}
