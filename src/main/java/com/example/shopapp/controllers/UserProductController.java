package com.example.shopapp.controllers;

import com.example.shopapp.model.Product;
import com.example.shopapp.repos.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserProductController {

    @Autowired
    public UserProductRepository userProductRepository;

    // add product to user product cart
    @PostMapping("/product/{userid}-{productid}/cart")
    String addProductToCart(@PathVariable Long userid, @PathVariable Long productid) {
        return userProductRepository.addProductToCart(userid, productid);
    }

    // remove product from user product cart
    @DeleteMapping("/product/{userid}-{productid}/cart")
    String removeProductFromCart(@PathVariable Long userid, @PathVariable Long productid) {
        return userProductRepository.removeProductFromCart(userid, productid);
    }

    // get user product cart
    @GetMapping("/product/{userid}/cart")
    Iterable<Product> getUserCart(@PathVariable Long userid) {
        return userProductRepository.getUserCart(userid);
    }

}
