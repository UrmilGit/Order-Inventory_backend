
package com.orderinventory.dto;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryProductCustomerStore {
	private Product product;
	private Customer customer;
	private Store store;
	
	public InventoryProductCustomerStore(Product product, Customer customer, Store store) {
		super();
		this.product = product;
		this.customer = customer;
		this.store = store;
	}
	
	public InventoryProductCustomerStore() {
		super();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
}
