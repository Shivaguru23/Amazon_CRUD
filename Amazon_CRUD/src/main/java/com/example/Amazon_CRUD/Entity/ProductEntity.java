
package com.example.Amazon_CRUD.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate ID
    @Column(name = "product_id")
    private Long productId;

    private Integer quantity;
    private Double rating;
    private Double price;
    private String manufacturer;

    @Temporal(TemporalType.TIMESTAMP) // store Date properly
    private Date date;

    private Boolean availability;

    public ProductEntity(Long productId, Integer quantity, Double rating, Double price, String manufacturer, Date date) {}

    public ProductEntity(Long productId, Integer quantity, Double rating, Double price,
                         String manufacturer, Date date, Boolean availability) {
        this.productId = productId;
        this.quantity = quantity;
        this.rating = rating;
        this.price = price;
        this.manufacturer = manufacturer;
        this.date = date;
        this.availability = availability;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Boolean getAvailability() { return availability; }
    public void setAvailability(Boolean availability) { this.availability = availability; }


    public void updateFromPojo(com.example.Amazon_CRUD.POJO.Product product) {
        this.productId = product.getProductId();
        this.quantity = product.getQuantity();
        this.rating = product.getRating();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.date = product.getDate();
    }
}
