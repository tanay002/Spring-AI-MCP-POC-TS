package com.ai.poc.ts.mcpserver.repository;

import com.ai.poc.ts.mcpserver.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
