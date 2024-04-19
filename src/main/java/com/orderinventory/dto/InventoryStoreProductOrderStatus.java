
package com.orderinventory.dto;

import java.util.List;

import com.orderinventory.entities.Store;

public class InventoryStoreProductOrderStatus {
	private Store store;
	private List<Object[]> object;
	
	public InventoryStoreProductOrderStatus(Store store, List<Object[]> object) {
		super();
		this.store = store;
		this.object = object;
	}
	
	public InventoryStoreProductOrderStatus() {
		super();
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	public List<Object[]> getObject() {
		return object;
	}
	
	public void setObject(List<Object[]> object) {
		this.object = object;
	}
	
}
