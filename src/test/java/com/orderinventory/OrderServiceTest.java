package com.orderinventory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.el.stream.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.orderinventory.controllers.OrderController;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;
import com.orderinventory.entities.Store;
import com.orderinventory.repo.OrderRepository;
import com.orderinventory.services.OrderServices;


@SpringBootTest
class OrderServiceTest {
	
	 @InjectMocks
	 private OrderServices orderServices;
//	@Mock
//    private OrderController orderController;
	@Mock
    private OrderRepository orderRepository;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this); // Initialize mocks
//
//        orderController = new OrderController();
//    }

    @Test
    void testGetAllOrders() {
        // Arrange
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order(1, Timestamp.valueOf("2024-04-15 12:00:00"), new Customer(), "Pending", new Store()));
        mockOrders.add(new Order(2, Timestamp.valueOf("2024-04-16 10:00:00"), new Customer(), "Shipped", new Store()));
        
        when(orderRepository.findAll()).thenReturn(mockOrders);

        // Act
        List<Order> actualOrders = orderServices.getAllOrders();

        // Assert
        assertThat(actualOrders).isNotNull();
        assertThat(actualOrders).hasSize(2);
        assertThat(actualOrders).containsExactlyElementsOf(mockOrders);
    }
    
    @Test
    void testGetOrderCountByStatus() {
        // Arrange
        String orderStatus = "CANCELLED";
        List<OrderStatusCount> mockOrderStatusCountList = new ArrayList<>();
        mockOrderStatusCountList.add(new OrderStatusCount("CANCELLED", 2L));
        when(orderServices.getOrderCountByStatus(orderStatus)).thenReturn(mockOrderStatusCountList);

        // Act
        List<OrderStatusCount> result = orderServices.getOrderCountByStatus(orderStatus);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(mockOrderStatusCountList.size());
        assertThat(result.get(0).getOrderStatus()).isEqualTo(mockOrderStatusCountList.get(0).getOrderStatus());
        assertThat(result.get(0).getCount()).isEqualTo(mockOrderStatusCountList.get(0).getCount());
    }
    
    
    @Test
    void testGetOrdersByStoreName() {
        // Arrange
        String storeName = "Online";
        List<Order> mockOrders = new ArrayList<>();
        // Populate mockOrders with some dummy data
        when(orderServices.getOrdersByStoreName(storeName)).thenReturn(mockOrders);

        // Act
        List<Order> result = orderServices.getOrdersByStoreName(storeName);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockOrders);
    }
    
    @Test
    void testGetOrdersByCustomerId() {
        // Arrange
        int customerId = 1;
        List<Order> mockOrders = new ArrayList<>();
        // Populate mockOrders with some dummy data
        when(orderServices.getOrdersByCustomerId(customerId)).thenReturn(mockOrders);

        // Act
        List<Order> result = orderServices.getOrdersByCustomerId(customerId);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockOrders);
    }
    
    @Test
    void testGetOrdersByOrderStatus() {
        // Arrange
        String orderStatus = "Complete";
        List<Order> mockOrders = new ArrayList<>();
        // Populate mockOrders with some dummy data
        when(orderServices.getOrdersByOrderStatus(orderStatus)).thenReturn(mockOrders);

        // Act
        List<Order> result = orderServices.getOrdersByOrderStatus(orderStatus);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockOrders);
    }
    
    @Test
    void testGetOrdersByCustomerEmail() {
        // Arrange
        String email = " gary.jenkins@internalmail";
        List<Order> mockOrders = new ArrayList<>();
        // Populate mockOrders with some dummy data
        when(orderServices.getOrdersByCustomerEmail(email)).thenReturn(mockOrders);

        // Act
        List<Order> result = orderServices.getOrdersByCustomerEmail(email);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockOrders);
    }



}

