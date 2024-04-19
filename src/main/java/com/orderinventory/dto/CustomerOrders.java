package com.orderinventory.dto;

import java.util.List;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;

public class CustomerOrders {
	private Customer customer;
	private List<Order> order;
	
	public CustomerOrders(Customer customer, List<Order> order) {
		super();
		this.customer = customer;
		this.order = order;
	}
	
	public CustomerOrders() {
		super();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Order> getOrder() {
		return order;
	}
	
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
}