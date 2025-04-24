package com.anycomp;

import com.anycomp.entity.Item;
import com.anycomp.entity.Seller;
import com.anycomp.service.ItemService;
import com.anycomp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ItemService itemService;

    // Get all sellers
    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    // Get a seller by ID
    @GetMapping("/{id}")
    public Optional<Seller> getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    // Create a new seller
    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    // Update a seller
    @PutMapping("/{id}")
    public Seller updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        return sellerService.updateSeller(id, seller);
    }

    // Delete a seller
    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }

    // Get list of items for specific seller
    @GetMapping("/{sellerId}/items")
    public List<Item> getItemsBySellerId(@PathVariable Long sellerId) {
        return itemService.getItemsBySellerId(sellerId);
    }

    // Add item based of given Seller ID
    @PostMapping("/{sellerId}/items")
    public Item createItemForSeller(@PathVariable Long sellerId, @RequestBody Item item) {
        return itemService.createItemForSeller(sellerId, item);
    }
}