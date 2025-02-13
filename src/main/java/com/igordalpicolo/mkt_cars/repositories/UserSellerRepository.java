package com.igordalpicolo.mkt_cars.repositories;

import com.igordalpicolo.mkt_cars.entities.UserSeller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSellerRepository extends JpaRepository<UserSeller, Long> {
}
