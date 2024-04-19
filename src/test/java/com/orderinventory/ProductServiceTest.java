package com.orderinventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orderinventory.entities.Product;
import com.orderinventory.repo.ProductRepository;
import com.orderinventory.services.ProductServices;

import jakarta.inject.Inject;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductServices prod;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetProductsByName() {
        // Arrange
        String productName = "Park Avenue";
        List<Product> mockProducts = new ArrayList<>(); // Create a list of mock products
        mockProducts.add(new Product(/* Add constructor parameters */)); // Add mock products to the list
        when(repo.findByProductName(productName)).thenReturn(mockProducts);

        // Act
        List<Product> response = prod.getProductsByName(productName);

        // Assert
        assertThat(response).isEqualTo(mockProducts);
    }
    
    @Test
    public void testGetProductsByBrand_WhenProductsFound() {
        // Arrange
        String brand = "Allen Solly";
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(/* Add constructor parameters */));
        when(repo.findByBrand(brand)).thenReturn(mockProducts);

        // Act
        List<Product> response = prod.getProductsByBrand(brand);

        // Assert
        assertThat(response).isEqualTo(mockProducts);
    }
    
    @Test
    public void testGetProductsByUnitPriceRange() {
        // Arrange
        BigDecimal minPrice = new BigDecimal("10.00");
        BigDecimal maxPrice = new BigDecimal("20.00");
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(/* Add constructor parameters */));
        when(repo.findByUnitPriceBetween(minPrice, maxPrice)).thenReturn(mockProducts);

        // Act
        List<Product> response = prod.getProductsByUnitPriceRange(minPrice, maxPrice);

        // Assert
        assertThat(response).isEqualTo(mockProducts);
    }
}
