package com.example.shopapp.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_table_product_cart")
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name="product_cart_id")
    private Product product;

    public UserProduct(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public UserProduct() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProduct that = (UserProduct) o;
        return Objects.equals(user.getId(), that.getUser().getId()) && product.getId().equals(that.getProduct().getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), product.getId());
    }
}
