package com.gopal.uberreviewservice;

import com.gopal.uberreviewservice.models.*;
import com.gopal.uberreviewservice.repositories.BookingRepository;
import com.gopal.uberreviewservice.repositories.DriverRepository;
import com.gopal.uberreviewservice.repositories.PassengeRepository;
import com.gopal.uberreviewservice.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing  // this will enable jpa to Auditing data (when update and when create ....)
public class UberReviewServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UberReviewServiceApplication.class, args);
    }

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    PassengeRepository passengeRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Driver driver = Driver.builder().name("kunj").licenseNumber("GJ_11_AB_0000").address("Junagadh").build();

//        driver = driverRepository.save(driver);

//        Passenger passenger = Passenger.builder().name("gopal").build();

//        passenger = passengeRepository.save(passenger);

        Optional<Passenger> passenger = passengeRepository.findById(1L);

        Optional<Driver> driver = driverRepository.findById(1L);

        Booking booking = Booking.builder().driver(driver.get()).passenger(passenger.get()).bookingStatus(BookingStatus.SCHEDULE).startTime(new Date()).endTime(new Date()).build();

//        booking = bookingRepository.save(booking);


        System.out.println(passenger);

        System.out.println(driver);

        System.out.println(booking);

//        System.out.println(review);

    }
}
