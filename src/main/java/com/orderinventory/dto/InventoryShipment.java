
package com.orderinventory.dto;

import com.orderinventory.entities.Inventory;
import com.orderinventory.entities.Shipment;

public class InventoryShipment {
	private Shipment shipment;
	private Inventory inventory;
	
	public InventoryShipment(Shipment shipment, Inventory inventory) {
		super();
		this.shipment = shipment;
		this.inventory = inventory;
	}
	
	public InventoryShipment() {
		super();
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
