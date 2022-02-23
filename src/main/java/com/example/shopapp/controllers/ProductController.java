package com.example.shopapp.controllers;

import com.example.shopapp.model.Product;
import com.example.shopapp.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    public ProductService productService;

    // get all products
    @GetMapping("/products")
    Iterable<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    ResponseEntity<Product> createProduct(@ModelAttribute Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


    // get all products with more than 50 present discount
    @GetMapping("/products/discount")
    Iterable<Product> getAllProductsWithDiscount() {
        return productService.getAllProductsWithDiscount();
    }
}
