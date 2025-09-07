package com.example.Amazon_CRUD.Service;

import com.example.Amazon_CRUD.Exception.duplicateRecord;
import com.example.Amazon_CRUD.POJO.Product;
import com.example.Amazon_CRUD.Repository.productRepository;
import com.example.Amazon_CRUD.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final productRepository productRepository;
    public ProductServiceImpl(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity convertToEntity(Product product) {
        return new ProductEntity(
                product.getProductId(),
                product.getQuantity(),
                product.getRating(),
                product.getPrice(),
                product.getManufacturer(),
                product.getDate()
        );
    }

    @Override
    public String addProduct(Product product) {
        ProductEntity entity = convertToEntity(product);
        List<ProductEntity> productEntityList = productRepository.findAll();
        for (ProductEntity p : productEntityList ){
            if (p.getProductId().equals(entity.getProductId())){
                throw new duplicateRecord("Product with ID " + entity.getProductId() + " already exists.");
            }
        }
        ProductEntity savedEntity = productRepository.save(entity);
        return savedEntity.getProductId() != null ? "Successfully saved" : "Failed to save";
    }

    @Override
    public void addMultipleProducts(List<Product> products) {
        List<ProductEntity> entities = products.stream()
                .map(product -> new ProductEntity(
                        product.getProductId(),
                        product.getQuantity(),
                        product.getRating(),
                        product.getPrice(),
                        product.getManufacturer(),
                        product.getDate(),
                        true // default availability
                ))
                .toList();

        productRepository.saveAll(entities); // saves in bulk
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean updateProductById(Long id, ProductEntity updatedProduct) {
        Optional<ProductEntity> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            ProductEntity product = existingProduct.get();

            // update only the fields from request
            product.setQuantity(updatedProduct.getQuantity());
            product.setRating(updatedProduct.getRating());
            product.setPrice(updatedProduct.getPrice());
            product.setManufacturer(updatedProduct.getManufacturer());
            product.setDate(updatedProduct.getDate());
            product.setAvailability(updatedProduct.getAvailability());

            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false; // product not found
    }
}
