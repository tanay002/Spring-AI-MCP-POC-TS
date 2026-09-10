package com.ai.poc.ts.mcpserver.mcp;

import com.ai.poc.ts.mcpserver.entity.Product;
import com.ai.poc.ts.mcpserver.repository.ProductRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMcpTools {

    private final ProductRepository productRepository;

    public ProductMcpTools(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Tool(name = "getProduct", description = "Get a product by its ID")
    public Product getProduct(@ToolParam(description = "Product ID") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Tool(name = "searchProducts", description = "Search products by name")
    public List<Product> searchProducts(@ToolParam(description = "Product name") String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Tool(name = "getProductsByCategory", description = "Find products by category")
    public List<Product> getProductsByCategory(@ToolParam(description = "Category name") String category) {
        return productRepository.findByCategoryNameIgnoreCase(category);
    }

    @Tool(name = "getAllProducts", description = "Get all products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}