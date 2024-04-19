package com.orderinventory.dto;

import com.orderinventory.entities.Customer;
import java.util.*;
import java.util.stream.Collectors;
 
 
public class CustomerDTO {
    private int id;
    private String fullName;
    private String emailAddress;
 
    // Constructor, getters, and setters
 
    public static CustomerDTO fromEntity(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getCustomerId());
        dto.setFullName(customer.getFullName());
        dto.setEmailAddress(customer.getEmailAddress());
        return dto;
    }
 
    public static List<CustomerDTO> fromEntities(List<Customer> customers) {
        return customers.stream()
                .map(CustomerDTO::fromEntity)
                .collect(Collectors.toList());
    }
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getFullName() {
		return fullName;
	}
 
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
 
	public String getEmailAddress() {
		return emailAddress;
	}
 
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
 
    // Getters and setters
    
}
