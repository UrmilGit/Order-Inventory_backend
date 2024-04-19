package com.orderinventory.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.orderinventory.dto.InventoryProductCustomerStore;
import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.dto.InventoryShipment;
import com.orderinventory.dto.ShipmentStatusSoldProducts;
import com.orderinventory.entities.Inventory;

public interface InventoryServiceInterface {
	
	public List<Inventory> getAllInventory();
	public InventoryProductCustomerStore getProductCustomerStoreByOrderId(int orderId);
	public List<InventoryProductStoreShipmentStatusSum> getInventoryDetailsByOrderId(@Param("orderId") int orderId);
	public List<InventoryShipment> getInventoryShipment();
	public ShipmentStatusSoldProducts getCountOfSoldProductsByShipmentStatus();

}