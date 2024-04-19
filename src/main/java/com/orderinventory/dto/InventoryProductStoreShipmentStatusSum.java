
package com.orderinventory.dto;

import java.math.BigDecimal;

import com.orderinventory.entities.Product;
import com.orderinventory.entities.Store;

public class InventoryProductStoreShipmentStatusSum {
	private Product product;
	private Store store;
	private String shipmentStatus;
	private BigDecimal total;

	
	public InventoryProductStoreShipmentStatusSum(Product product, Store store, String shipmentStatus, BigDecimal total) {
		super();
		this.product = product;
		this.store = store;
		this.shipmentStatus = shipmentStatus;
		this.total = total;
	}

	
	public InventoryProductStoreShipmentStatusSum() {
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

	
	public String getShipmentStatus() {
		return shipmentStatus;
	}

	
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	
	public BigDecimal getTotal() {
		return total;
	}

	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
