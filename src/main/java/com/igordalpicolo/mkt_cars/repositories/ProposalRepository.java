package com.igordalpicolo.mkt_cars.repositories;

import com.igordalpicolo.mkt_cars.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
