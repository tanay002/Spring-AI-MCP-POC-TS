package com.ai.poc.ts.mcpserver.repository;

import com.ai.poc.ts.mcpserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoryNameIgnoreCase(String category);
}