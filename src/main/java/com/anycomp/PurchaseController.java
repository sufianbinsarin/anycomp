package com.anycomp;

import com.anycomp.dto.PurchaseRequest;
import com.anycomp.entity.Purchase;
import com.anycomp.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> processPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        Purchase purchase = purchaseService.processPurchase(purchaseRequest);
        return new ResponseEntity<>(purchase, HttpStatus.CREATED);
    }
}