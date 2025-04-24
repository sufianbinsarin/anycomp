package com.anycomp.repository;

import com.anycomp.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    // Example custom query method
    List<Seller> findByNameContaining(String keyword);
}