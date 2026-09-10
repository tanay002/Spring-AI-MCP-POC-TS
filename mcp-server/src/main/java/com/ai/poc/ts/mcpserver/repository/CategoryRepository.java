package com.ai.poc.ts.mcpserver.repository;

import com.ai.poc.ts.mcpserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}