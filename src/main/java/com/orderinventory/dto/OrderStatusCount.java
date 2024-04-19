package com.orderinventory.dto;

public class OrderStatusCount {
	
	private String orderStatus;
	private Long count;
	
	
	public OrderStatusCount() {
		super();
	}

	
	public OrderStatusCount(String orderStatus, Long count) {
		super();
		this.orderStatus = orderStatus;
		this.count = count;
	}

	
	public String getOrderStatus() {
		return orderStatus;
	}

	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	public Long getCount() {
		return count;
	}

	
	public void setCount(Long count) {
		this.count = count;
	}
}