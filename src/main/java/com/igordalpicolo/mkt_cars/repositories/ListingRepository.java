package com.igordalpicolo.mkt_cars.repositories;

import com.igordalpicolo.mkt_cars.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
