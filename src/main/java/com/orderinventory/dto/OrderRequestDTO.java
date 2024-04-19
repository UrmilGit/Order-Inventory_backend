package com.orderinventory.dto;
 
public class OrderRequestDTO {
    private String orderStatus;
    private int customerId;
    private int storeId;
 
    // Constructor, getters, and setters
 
    public OrderRequestDTO() {
        // Default constructor
    }
 
    public OrderRequestDTO(String orderStatus, int customerId, int storeId) {
        this.orderStatus = orderStatus;
        this.customerId = customerId;
        this.storeId = storeId;
    }
 
	public String getOrderStatus() {
		return orderStatus;
	}
 
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
 
	public int getCustomerId() {
		return customerId;
	}
 
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
 
	public int getStoreId() {
		return storeId;
	}
 
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
 
    // Getters and setters
    
}
 
