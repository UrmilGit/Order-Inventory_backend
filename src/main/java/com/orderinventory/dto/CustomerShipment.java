package com.orderinventory.dto;

import java.util.List;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Shipment;

public class CustomerShipment {
	private Customer customer;
	private List<Shipment> shipment;
	
	public CustomerShipment(Customer customer, List<Shipment> shipment) {
		super();
		this.customer = customer;
		this.shipment = shipment;
	}
	
	public CustomerShipment() {
		super();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Shipment> getShipment() {
		return shipment;
	}
	
	public void setShipment(List<Shipment> shipment) {
		this.shipment = shipment;
	}
	
	
}