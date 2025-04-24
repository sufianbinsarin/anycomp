package com.anycomp.service;

import com.anycomp.entity.Buyer;
import com.anycomp.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    // Fetch all buyers
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    // Fetch a buyer by ID
    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    // Create a new buyer
    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    // Update an existing buyer
    public Buyer updateBuyer(Long id, Buyer updatedBuyer) {
        return buyerRepository.findById(id).map(buyer -> {
            buyer.setName(updatedBuyer.getName());
            buyer.setEmail(updatedBuyer.getEmail());
            return buyerRepository.save(buyer);
        }).orElseThrow(() -> new RuntimeException("Buyer not found"));
    }

    // Delete a buyer by ID
    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }
}