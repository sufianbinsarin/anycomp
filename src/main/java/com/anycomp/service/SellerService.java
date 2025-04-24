package com.anycomp.service;

import com.anycomp.entity.Seller;
import com.anycomp.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    // Fetch all sellers
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    // Fetch a seller by ID
    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    // Create a new seller
    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    // Update an existing seller
    public Seller updateSeller(Long id, Seller updatedSeller) {
        return sellerRepository.findById(id).map(seller -> {
            seller.setName(updatedSeller.getName());
            seller.setEmail(updatedSeller.getEmail());
            return sellerRepository.save(seller);
        }).orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    // Delete a seller by ID
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}