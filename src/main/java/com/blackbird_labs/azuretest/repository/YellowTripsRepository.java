package com.blackbird_labs.azuretest.repository;

import com.blackbird_labs.azuretest.model.YellowTrips;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YellowTripsRepository extends JpaRepository<YellowTrips, UUID> {

}
