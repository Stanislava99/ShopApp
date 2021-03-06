package com.example.shopapp.model;

import com.example.shopapp.Helper.ProductType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private int price;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "discount_percentage")
    private int discountPercentage;

    @Column(name = "discount_price")
    private int discountPrice;

    @Column(name = "discount_days")
    private LocalDate duration_date;

    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product() {
    }

    public Product(String name, int price, String description, String companyName, int discountPercentage, LocalDate duration_date, String imageUrl, String productType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.companyName = companyName;
        this.discountPercentage = discountPercentage;
        this.duration_date = duration_date;
        this.imageUrl = imageUrl;
        this.productType = ProductType.valueOf(productType);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPercentage) {
        this.discountPrice = this.price - (this.price * 20)/100;
    }

    public LocalDate getDuration_date() {
        return duration_date;
    }

    public void setDuration_date(LocalDate discountDays) {
        this.duration_date = discountDays;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && discountPercentage == product.discountPercentage && discountPrice == product.discountPrice && duration_date == product.duration_date && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(companyName, product.companyName) && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, companyName, discountPercentage, discountPrice, duration_date, imageUrl);
    }
}
