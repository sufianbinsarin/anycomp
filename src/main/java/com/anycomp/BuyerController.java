package com.anycomp;

import com.anycomp.entity.Buyer;
import com.anycomp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    // Get all buyers
    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    // Get a buyer by ID
    @GetMapping("/{id}")
    public Optional<Buyer> getBuyerById(@PathVariable Long id) {
        return buyerService.getBuyerById(id);
    }

    // Create a new buyer
    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    // Update a buyer
    @PutMapping("/{id}")
    public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
        return buyerService.updateBuyer(id, buyer);
    }

    // Delete a buyer
    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
    }
}