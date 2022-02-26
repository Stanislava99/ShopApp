package com.example.shopapp.controllers;

import com.example.shopapp.model.Product;
import com.example.shopapp.services.ProductService;
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
    ResponseEntity<Product> createProduct(@ModelAttribute Product product, @RequestParam Long id) {
        return (productService.createProduct(product,id) != null) ?
                ResponseEntity.ok(productService.createProduct(product,id)) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/product/{id}")
    String deleteProduct(@PathVariable Long id,  @RequestParam Long personId) {
        return  productService.deleteProduct(id,personId);
    }


    // get all products with discount
    @GetMapping("/products/discount")
    Iterable<Product> getAllProductsWithDiscount()   {
        return productService.getAllProductsWithDiscount();
    }

    // get products with 50% or more discount
    @GetMapping("/products/discount/50")
    Iterable<Product> getProductsWith50PercentDiscount() {
        return productService.getProductsWith50PercentDiscount();
    }

    // get products with 3 days left for discount
    @GetMapping("/products/discount/3days")
    Iterable<Product> getProductsWith3DaysLeftForDiscount() {
        return productService.getProductsWith3DaysLeftForDiscount();
    }

}
