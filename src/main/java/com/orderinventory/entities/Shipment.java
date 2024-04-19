
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

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private int shipmentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "delivery_address", nullable = false, length = 512)
    private String deliveryAddress;

    @Column(name = "shipment_status", nullable = false, length = 100)
    private String shipmentStatus;

    
    public Shipment() {}

    
    public Shipment(Store store, Customer customer, String deliveryAddress, String shipmentStatus) {
        this.store = store;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.shipmentStatus = shipmentStatus;
    }
    
    
    public Shipment(int shipmentId, Store store, Customer customer, String deliveryAddress, String shipmentStatus) {
    	this.shipmentId = shipmentId;
        this.store = store;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.shipmentStatus = shipmentStatus;
    }

    
    public int getShipmentId() {
        return shipmentId;
    }

    
    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    
    public Store getStore() {
        return store;
    }

    
    public void setStore(Store store) {
        this.store = store;
    }

    
    public Customer getCustomer() {
        return customer;
    }

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    
    public String getShipmentStatus() {
        return shipmentStatus;
    }

    
    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }
}
