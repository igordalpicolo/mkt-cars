package com.igordalpicolo.mkt_cars.repositories;

import com.igordalpicolo.mkt_cars.entities.UserBuyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBuyerRepository extends JpaRepository<UserBuyer, Long> {
}
