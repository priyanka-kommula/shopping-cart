package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.ProductEntity;
import com.example.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
