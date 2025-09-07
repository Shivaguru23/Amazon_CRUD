package com.example.Amazon_CRUD.Service;

import com.example.Amazon_CRUD.Repository.productRepository;
import com.example.Amazon_CRUD.Entity.ProductEntity;
import com.example.Amazon_CRUD.POJO.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    String addProduct(Product product);

    void addMultipleProducts(List<Product> products);


    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(Long id);

    boolean updateProductById(Long id, ProductEntity updatedProduct);

    boolean deleteProductById(Long id);
}
