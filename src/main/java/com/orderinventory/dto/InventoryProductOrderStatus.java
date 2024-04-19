
package com.orderinventory.dto;

import com.orderinventory.entities.Product;

public class InventoryProductOrderStatus {
	private Product product;
	private String orderStatus;
	
	public InventoryProductOrderStatus(Product product, String orderStatus) {
		super();
		this.product = product;
		this.orderStatus = orderStatus;
	}
	
	public InventoryProductOrderStatus() {
		super();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
