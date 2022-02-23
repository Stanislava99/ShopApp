package com.example.shopapp.services;

import com.example.shopapp.repos.ProductRepository;
import com.example.shopapp.repos.UserProductRepository;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserProductRepository userProductRepository;


    public String addProductToCart(Long userId, Long productId) {
        if(userRepository.findById(userId).isPresent() && productRepository.findById(productId).isPresent()) {
            userProductRepository.save(userId, productId);
        }
        return "User or product not found";
    }
    }
}
