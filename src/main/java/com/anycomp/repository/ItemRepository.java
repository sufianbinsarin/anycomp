package com.anycomp.repository;

import com.anycomp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Add custom query methods if needed, for example:
    List<Item> findByName(String name);

    List<Item> findItemsBySellerId(Long sellerId);
}