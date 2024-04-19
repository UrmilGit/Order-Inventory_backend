
package com.orderinventory.dto;

public class ShipmentStatusCountCustomer {
	private String shipmentStatus;
	private Long count;
	
	public ShipmentStatusCountCustomer(String shipmentStatus, Long count) {
		super();
		this.shipmentStatus = shipmentStatus;
		this.count = count;
	}
	
	public ShipmentStatusCountCustomer() {
		super();
	}
	
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}
}
