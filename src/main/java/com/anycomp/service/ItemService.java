package com.anycomp.service;

import com.anycomp.entity.Item;
import com.anycomp.entity.Seller;
import com.anycomp.repository.ItemRepository;
import com.anycomp.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SellerRepository sellerRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get an item by ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Create a new item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Update an existing item
    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setDescription(updatedItem.getDescription());
            item.setPrice(updatedItem.getPrice());
            item.setQuantity(updatedItem.getQuantity());
            item.setSeller(updatedItem.getSeller());
            return itemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    // Delete an item by ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Additional custom logic (example: Get items by seller ID)
    public List<Item> getItemsBySellerId(Long sellerId) {
        return itemRepository.findItemsBySellerId(sellerId);
    }

    // Add item based of given Seller Id
    public Item createItemForSeller(Long sellerId, Item item) {
        // Find the seller by ID
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        // Associate the item with the seller
        item.setSeller(seller);

        // Save the item to the database
        return itemRepository.save(item);
    }
}