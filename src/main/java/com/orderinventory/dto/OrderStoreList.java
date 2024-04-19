
package com.orderinventory.dto;

public class OrderStoreList {
	private int orderId;
	private String orderStatus;
	private String storeName;
	private String webAddress;
	
	
	public OrderStoreList() {
		super();
	}
	
	public OrderStoreList(int orderId, String orderStatus, String storeName, String webAddress) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.storeName = storeName;
		this.webAddress = webAddress;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getWebAddress() {
		return webAddress;
	}
	
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
}
