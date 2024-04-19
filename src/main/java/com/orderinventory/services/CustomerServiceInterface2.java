package com.orderinventory.services;

import java.util.List;

import com.orderinventory.dto.CustomerOrders;
import com.orderinventory.dto.CustomerShipment;
import com.orderinventory.dto.ShipmentStatusCountCustomer;
import com.orderinventory.entities.Customer;
import com.orderinventory.exceptions.InvalidCustomerIdException;


public interface CustomerServiceInterface2 {
	
	Customer getCustomerById(int customerId);
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public String deleteCustomer(int id) throws InvalidCustomerIdException;
	public List<Customer> getCustomerByEmailAddress(String emialAddress);
	public List<Customer> getCustomersByFullName(String fullName);
	public List<ShipmentStatusCountCustomer> getOrderCountByStatus();
	public CustomerOrders getCustomerOrders(int customerId);
	public CustomerShipment getCustomerShipment(int customerId);
	
    
}