package com.example.shopapp.services;

import com.example.shopapp.model.Product;
import com.example.shopapp.model.User;
import com.example.shopapp.repos.ProductRepository;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Product deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return product.get();
        }
        return null;
    }

    public String addProductToCart(Long userid, Long productid) {
        User user = userRepository.findById(userid).get();
        Product product = productRepository.findById(productid).get();

        if (user.getProductCart().contains(product)) {
            return "Product already in cart";
        }
        else {
            user.setProductCart(product);
            return "Product added to cart";
        }
    }
}
