package com.example.shopapp.services;
import com.example.shopapp.Helper.Role;
import com.example.shopapp.model.Product;
import com.example.shopapp.model.User;
import com.example.shopapp.model.UserProduct;
import com.example.shopapp.repos.ProductRepository;
import com.example.shopapp.repos.UserProductRepository;
import com.example.shopapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProductRepository userProductRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product, Long id) {
        if (userRepository.findById(id).get().getRole() == Role.ADMIN) {
            return productRepository.save(product);
        }
        else {
            return null;
        }
    }


    public String deleteProduct(Long id, Long personId) {
        if (userRepository.findById(personId).get().getRole() == Role.ADMIN) {
            if (productRepository.findById(id).isPresent()) {
                for (UserProduct userProduct : userProductRepository.findAll()) {
                    if (Objects.equals(userProduct.getProduct().getId(), id)) {
                        userProductRepository.delete(userProduct);
                    }
                }
                productRepository.deleteById(id);
                return "Product deleted";
            }
        }
        return "Product not deleted";
    }


    public Iterable<Product> getAllProductsWithDiscount() {
        List<Product> products = productRepository.findAll();
        List<Product> productsWithDiscount = new ArrayList<>();
        for (Product product : products) {
            if (product.getDiscountPercentage() > 0) {
                productsWithDiscount.add(product);
            }
        }
        return productsWithDiscount;
    }


    public Iterable<Product> getProductsWith50PercentDiscount() {
        List<Product> products = productRepository.findAll();
        List<Product> productsWithDiscount = new ArrayList<>();
        for (Product product : products) {
            if (product.getDiscountPercentage() > 50) {
                productsWithDiscount.add(product);
            }
        }
        return productsWithDiscount;
    }

    public Iterable<Product> getProductsWith3DaysLeftForDiscount() {
        List<Product> products = productRepository.findAll();
        List<Product> productsWith3DaysDiscount = new ArrayList<>();
        for (Product product : products) {
            if (product.getDiscountDays() < 4) {
                productsWith3DaysDiscount.add(product);
            }
        }
        return productsWith3DaysDiscount;
    }
}
