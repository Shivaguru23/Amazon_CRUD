package com.example.Amazon_CRUD.Controller;

import com.example.Amazon_CRUD.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Amazon_CRUD.POJO.Product;
import com.example.Amazon_CRUD.Service.ProductService;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //Method for C
    @PostMapping ("/add")
    public String addProduct(@Valid @RequestBody Product product) {
        String Message =  productService.addProduct(product);
        return Message;
    }

    @PostMapping("/add-multiple")
    public ResponseEntity<String> addMultipleProducts(@Valid @RequestBody List<Product> products) {
        productService.addMultipleProducts(products);
        return ResponseEntity.ok("Products added successfully: " + products.size());
    }

    //Method for R
    @GetMapping("/all")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById( @Valid @PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Method for U
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProductById(@Valid @PathVariable Long id,
                                                    @RequestBody ProductEntity updatedProduct) {
        boolean updated = productService.updateProductById(id, updatedProduct);
        if (updated) {
            return ResponseEntity.ok("Product updated successfully with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Method for D
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@Valid @PathVariable Long id) {
        boolean deleted = productService.deleteProductById(id);
        if (deleted) {
            return ResponseEntity.ok("Product deleted successfully with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
