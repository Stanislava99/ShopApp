package com.example.shopapp.services;

import com.example.shopapp.model.Product;
import com.example.shopapp.model.UserProduct;
import com.example.shopapp.repos.ProductRepository;
import com.example.shopapp.repos.UserProductRepository;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
            userProductRepository.save(new UserProduct(userRepository.findById(userId).get(), productRepository.findById(productId).get()));
        }
        return "User or product not found";
    }

    public String removeProductFromCart(Long userid, Long productid) {
        if (userProductRepository.findByUserIdAndProductId(userid, productid).isPresent()) {
            userProductRepository.delete(userProductRepository.findByUserIdAndProductId(userid, productid).get());
            return "Product removed from cart";
        }
        else {
            return "Product not found in cart";
        }
    }

    public Iterable<Product> getUserCart(Long userid) {
        return userProductRepository.findByUserId(userid).stream().map(UserProduct::getProduct).collect(Collectors.toList());
    }
}
