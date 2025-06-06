package com.gopal.uberreviewservice.repositories;

import com.gopal.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    List<Driver> findAllByIdAndLicenseNumber(Long id, String licenseNumber);
}
