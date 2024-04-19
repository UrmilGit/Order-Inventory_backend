
package com.orderinventory.dto;

import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryByStoreId {
	private Product product;
	private Store store;
	private String orderStatus;
	
	public InventoryByStoreId(Product product, Store store, String orderStatus) {
		super();
		this.product = product;
		this.store = store;
		this.orderStatus = orderStatus;
	}
	
	public InventoryByStoreId() {
		super();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
