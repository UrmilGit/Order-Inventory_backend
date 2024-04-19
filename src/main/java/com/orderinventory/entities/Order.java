
package com.orderinventory.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@CreationTimestamp
	@Column(name = "order_tms", nullable = false)
	private Timestamp orderTimestamp;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "order_status", nullable = false, length = 45)
	private String orderStatus;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	
	public Order() {}

	
	public Order(Timestamp orderTimestamp, Customer customer, String orderStatus, Store store) {
		this.orderTimestamp = orderTimestamp;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.store = store;
	}

	
	public Order(int orderId, Timestamp orderTimestamp, Customer customer, String orderStatus, Store store) {
		this.orderId = orderId;
		this.orderTimestamp = orderTimestamp;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.store = store;
	}

	
	public int getOrderId() {
		return orderId;
	}

	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public Timestamp getOrderTimestamp() {
		return orderTimestamp;
	}

	
	public void setOrderTimestamp(Timestamp orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public String getOrderStatus() {
		return orderStatus;
	}

	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	public Store getStore() {
		return store;
	}

	
	public void setStore(Store store) {
		this.store = store;
	}
}
