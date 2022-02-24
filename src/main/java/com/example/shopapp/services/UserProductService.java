package com.example.shopapp.services;

import com.example.shopapp.model.Product;
import com.example.shopapp.model.UserProduct;
import com.example.shopapp.repos.ProductRepository;
import com.example.shopapp.repos.UserProductRepository;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
            return "Product added to cart";
        } else {
            return "User or product not found";
        }
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

    // return all products for userid
    public List<Product> getUserCart(Long userid) {
        List<UserProduct> allProducts = userProductRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (UserProduct up : allProducts) {
            if (Objects.equals(up.getUser().getId(), userid)) {
                products.add(up.getProduct());
            }
        }
        return products;
    }

}
