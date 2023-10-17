// Author: Stanton Barbadillo
// Import statements for necessary libraries and classes
package com.example.demo.controllers;
import com.example.demo.services.Checkout;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

// Allowing Cross-Origin requests from http://localhost:4200
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private Checkout checkout;
    public CheckoutController(Checkout checkout) {
        this.checkout = checkout;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkout.placeOrder(purchase);
        return purchaseResponse;
    }
}