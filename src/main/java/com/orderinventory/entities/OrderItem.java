
package com.orderinventory.entities;

import java.math.BigDecimal;

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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "order_items", 
uniqueConstraints = {@UniqueConstraint(name = "order_items_product_u", columnNames = {"product_id", "orders_id"})})
public class OrderItem {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name ="orders_id", referencedColumnName = "order_id", nullable = false)
	private Order order;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "line_item_id", nullable = false)
	private int lineItemId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
	private Product product;

	@Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal unitPrice;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "shipment_id")
	private Shipment shipment;
	
	
	public OrderItem() {
		super();
	}

	
	public OrderItem(Order order, int lineItemId, Product product, BigDecimal unitPrice, int quantity,
			Shipment shipment) {
		super();
		this.order = order;
		this.lineItemId = lineItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipment = shipment;
	}
	
	
	
	public OrderItem(int id, Order order, int lineItemId, Product product, BigDecimal unitPrice, int quantity,
			Shipment shipment) {
		super();
//		this.id = id;
		this.order = order;
		this.lineItemId = lineItemId;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.shipment = shipment;
	}
	

	
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}

	
	public Order getOrder() {
		return order;
	}

	
	public void setOrder(Order order) {
		this.order = order;
	}

	
	public int getLineItemId() {
		return lineItemId;
	}

	
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	
	public Product getProduct() {
		return product;
	}

	
	public void setProduct(Product product) {
		this.product = product;
	}

	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Shipment getShipmentId() {
		return shipment;
	}

	
	public void setShipmentId(Shipment shipment) {
		this.shipment = shipment;
	}
	
}
