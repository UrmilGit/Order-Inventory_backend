package com.orderinventory;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.orderinventory.entities.Customer;
import com.orderinventory.repo.CustomerRepository;
import com.orderinventory.repo.OrderRepository;
import com.orderinventory.services.CustomerServices;
import com.orderinventory.services.OrderServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.*;

@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	 private CustomerServices customerServices;

	@Mock
   private CustomerRepository customerRepository;
	
	@Test
    void testGetAllCustomers() {
        // Arrange
        List<Customer> mockCustomers = new ArrayList<>();
        // Populate mockCustomers with some dummy data
        when(customerServices.getAllCustomers()).thenReturn(mockCustomers);

        // Act
        List<Customer> result = customerServices.getAllCustomers();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(mockCustomers);
    }
	
	@Test
    void testGetCustomersByEmailAddress() {
        // Arrange
        String emailAddress = "gary.jenkins@internalmail";
        List<Customer> mockCustomers = new ArrayList<>(); // Create a list of mock customers
        mockCustomers.add(new Customer()); // Add mock customers to the list
        when(customerServices.getCustomerByEmailAddress(emailAddress)).thenReturn(mockCustomers);

        // Act
        List<Customer> response = customerServices.getCustomerByEmailAddress(emailAddress);

        // Assert
        assertThat(response).isEqualTo(mockCustomers);
    }
	
	 @Test
	    void testGetCustomersByFullName() {
	        // Arrange
	        String fullName = "John Doe";
	        List<Customer> mockCustomers = new ArrayList<>(); // Create a list of mock customers
	        mockCustomers.add(new Customer()); // Add mock customers to the list
	        when(customerServices.getCustomersByFullName(fullName)).thenReturn(mockCustomers);

	        // Act
	        List<Customer> response = customerServices.getCustomersByFullName(fullName);

	        // Assert
	       
	        assertThat(response).isEqualTo(mockCustomers);
	    }

 
}
