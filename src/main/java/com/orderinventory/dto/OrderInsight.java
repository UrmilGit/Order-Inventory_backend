
package com.orderinventory.dto;

import java.math.BigDecimal;

public class OrderInsight {
	private Long noOfOrders;
	private Long quantity;
	private Integer month;
	private BigDecimal totalSales;
	
	public OrderInsight(Long noOfOrders, Long quantity, Integer month, BigDecimal totalSales) {
		super();
		this.noOfOrders = noOfOrders;
		this.quantity = quantity;
		this.month = month;
		this.totalSales = totalSales;
	}
	
	public OrderInsight() {
		super();
	}
	
	public Long getNoOfOrders() {
		return noOfOrders;
	}
	
	public void setNoOfOrders(Long noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public BigDecimal getTotalSales() {
		return totalSales;
	}
	
	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
}
