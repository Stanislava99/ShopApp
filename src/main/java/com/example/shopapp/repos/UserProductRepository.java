package com.example.shopapp.repos;

import com.example.shopapp.model.Product;
import com.example.shopapp.model.UserProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    Optional<UserProduct> findByUserIdAndProductId(Long userId, Long productId);

    Optional<UserProduct> findByUserId(Long userId);
}
