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
    ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    // add product to user product cart
    @PostMapping("/product/{userid}-{productid} /cart")
    String addProductToCart(@PathVariable Long userid, @PathVariable Long productid) {
        return productService.addProductToCart(userid, productid);
    }

    // remove product from user product cart
    @DeleteMapping("/product/{userid}-{productid} /cart")
    String removeProductFromCart(@PathVariable Long userid, @PathVariable Long productid) {
        return productService.removeProductFromCart(userid, productid);
    }

    // get user product cart
    @GetMapping("/product/{userid} /cart")
    Iterable<Product> getUserCart(@PathVariable Long userid) {
        return productService.getUserCart(userid);
    }

}
