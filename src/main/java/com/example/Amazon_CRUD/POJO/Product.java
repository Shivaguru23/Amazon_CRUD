package com.example.Amazon_CRUD.POJO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import java.util.Date;


public class Product {
    @NotNull(message = "Product ID cannot be null")
    @Size(min = 1, max = 20, message = "Product ID length must be between 1 and 20 digits")
    private Long productId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "Quantity must be zero or positive")
    private Integer quantity;

    @NotNull(message = "Rating cannot be null")
    @jakarta.validation.constraints.DecimalMin(value = "0.0", inclusive = true, message = "Rating must be at least 0.0")
    @jakarta.validation.constraints.DecimalMax(value = "5.0", inclusive = true, message = "Rating cannot exceed 5.0")
    private Double rating;

    @NotNull(message = "Price cannot be null")
    @jakarta.validation.constraints.DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0.0")
    private Double price;

    @jakarta.validation.constraints.NotBlank(message = "Manufacturer cannot be blank")
    private String manufacturer;

    @NotNull(message = "Date cannot be null")
    private Date date;

    // Getters and setters
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return java.util.Objects.equals(productId, product.productId)
                && java.util.Objects.equals(quantity, product.quantity)
                && java.util.Objects.equals(rating, product.rating)
                && java.util.Objects.equals(price, product.price)
                && java.util.Objects.equals(manufacturer, product.manufacturer)
                && java.util.Objects.equals(date, product.date);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(productId, quantity, rating, price, manufacturer, date);
    }

}
