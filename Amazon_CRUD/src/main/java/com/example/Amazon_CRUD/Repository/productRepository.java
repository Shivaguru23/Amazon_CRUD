package com.example.Amazon_CRUD.Repository;

import com.example.Amazon_CRUD.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<ProductEntity, Long> {
}
