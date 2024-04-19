package com.orderinventory;

import org.apache.el.stream.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orderinventory.dto.InventoryProductCustomerStore;
import com.orderinventory.dto.InventoryProductOrderStatus;
import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.entities.Inventory;
import com.orderinventory.entities.Store;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.repo.InventoryRepository;
import com.orderinventory.repo.StoreRepository;
import com.orderinventory.services.InventoryServices;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;
    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private InventoryServices inventoryServices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllInventory() {
        // Arrange
        List<Inventory> mockInventoryList = new ArrayList<>();
        // Populate mockInventoryList with some dummy data
        // For example:
        mockInventoryList.add(new Inventory(/* Add constructor parameters */));
        mockInventoryList.add(new Inventory(/* Add constructor parameters */));
        when(inventoryRepository.findAll()).thenReturn(mockInventoryList);

        // Act
        List<Inventory> result = inventoryServices.getAllInventory();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockInventoryList);
    }
    
    @Test
    public void testGetInventoryDetailsByOrderId_WhenDetailsFound() {
        // Arrange
        int orderId = 1; // Replace with actual order ID
        List<InventoryProductStoreShipmentStatusSum> mockInventoryDetails = new ArrayList<>();
        // Populate mockInventoryDetails with some dummy data
        when(inventoryRepository.findInventoryDetailsByOrderId(orderId)).thenReturn(mockInventoryDetails);

        // Act
        List<InventoryProductStoreShipmentStatusSum> result = inventoryServices.getInventoryDetailsByOrderId(orderId);

        // Assert
        assertThat(result).isEqualTo(mockInventoryDetails);
    }
    
    @Test
    public void testGetProductCustomerStoreByOrderId_WhenFound() {
        // Arrange
        int orderId = 123; // Replace with the actual orderId
        InventoryProductCustomerStore mockProductCustomerStore = new InventoryProductCustomerStore(/* Add constructor parameters */);
        when(inventoryRepository.findProductCustomerStoreByOrderId(orderId)).thenReturn(mockProductCustomerStore);

        // Act
        InventoryProductCustomerStore result = inventoryServices.getProductCustomerStoreByOrderId(orderId);

        // Assert
        assertThat(result).isEqualTo(mockProductCustomerStore);
    }
   
}

