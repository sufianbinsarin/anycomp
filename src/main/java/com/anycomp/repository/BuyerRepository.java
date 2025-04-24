package com.anycomp.repository;

import com.anycomp.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    // Example custom query method
    Optional<Buyer> findByEmail(String email);
}
