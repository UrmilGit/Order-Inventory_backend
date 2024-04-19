
package com.orderinventory.dto;

public class ShipmentStatusSoldProducts {
	private String shipmentStatus;
	private Long soldProducts;
	
	public ShipmentStatusSoldProducts(String shipmentStatus, Long soldProducts) {
		super();
		this.shipmentStatus = shipmentStatus;
		this.soldProducts = soldProducts;
	}
	
	public ShipmentStatusSoldProducts() {
		super();
	}
	
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	public Long getSoldProducts() {
		return soldProducts;
	}
	
	public void setSoldProducts(Long soldProducts) {
		this.soldProducts = soldProducts;
	}
	
}
