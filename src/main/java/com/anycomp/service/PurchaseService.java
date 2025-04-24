package com.anycomp.service;

import com.anycomp.dto.PurchaseRequest;
import com.anycomp.entity.Buyer;
import com.anycomp.entity.Item;
import com.anycomp.entity.Purchase;
import com.anycomp.exception.InsufficientStockException;
import com.anycomp.repository.BuyerRepository;
import com.anycomp.repository.ItemRepository;
import com.anycomp.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase processPurchase(PurchaseRequest purchaseRequest) {
        // Fetch the item
        Item item = itemRepository.findById(purchaseRequest.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // Check stock availability
        if (item.getQuantity() < purchaseRequest.getQuantity()) {
            System.out.println("Stock insufficient for item: " + item.getName());
            throw new InsufficientStockException("Insufficient stock available for item: " + item.getName());
        }

        // Fetch the buyer
        Buyer buyer = buyerRepository.findById(purchaseRequest.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        // Deduct stock
        item.setQuantity(item.getQuantity() - purchaseRequest.getQuantity());
        itemRepository.save(item);

        // Create a new purchase
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(purchaseRequest.getQuantity());
        return purchaseRepository.save(purchase);
    }
}