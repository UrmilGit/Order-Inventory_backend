
package com.orderinventory.entities;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventory",
        indexes = {@Index(name = "inventory_product_id_fk", columnList = "product_id")})
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    @Column(name = "product_inventory", nullable = false)
    private int productInventory;

    
    public Inventory() {}

    
    public Inventory(Store store, Product product, int productInventory) {
        this.store = store;
        this.product = product;
        this.productInventory = productInventory;
    }
    
    public Inventory(int inventoryId, Store store, Product product, int productInventory) {
    	this.inventoryId = inventoryId;
        this.store = store;
        this.product = product;
        this.productInventory = productInventory;
    }

    
    public int getInventoryId() {
        return inventoryId;
    }

    
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    
    public Store getStore() {
        return store;
    }

    
    public void setStore(Store store) {
        this.store = store;
    }

    
    public Product getProduct() {
        return product;
    }

   
    public void setProduct(Product product) {
        this.product = product;
    }

   
    public int getProductInventory() {
        return productInventory;
    }

    
    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }
}
