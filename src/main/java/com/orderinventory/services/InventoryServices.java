package com.orderinventory.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.orderinventory.dto.InventoryProductCustomerStore;

import com.orderinventory.dto.InventoryProductStoreShipmentStatusSum;
import com.orderinventory.dto.InventoryShipment;
import com.orderinventory.dto.ShipmentStatusSoldProducts;
import com.orderinventory.entities.Inventory;

import com.orderinventory.repo.InventoryRepository;
import com.orderinventory.repo.ShipmentRepository;


@Service
public class InventoryServices implements InventoryServiceInterface {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public InventoryProductCustomerStore getProductCustomerStoreByOrderId(int orderId) {
		return inventoryRepository.findProductCustomerStoreByOrderId(orderId);
	}

	@Override
	public List<InventoryProductStoreShipmentStatusSum> getInventoryDetailsByOrderId(@Param("orderId") int orderId) {
		return inventoryRepository.findInventoryDetailsByOrderId(orderId);
	}

	@Override
	public List<InventoryShipment> getInventoryShipment() {
		List<Integer> allId = shipmentRepository.findAllShipmentId();
		List<InventoryShipment> inventoryShipment = new ArrayList<>();
		for (int id : allId) {
			inventoryShipment.add(inventoryRepository.findInventoryShipment(id));
		}
		return inventoryShipment;
	}

	@Override
	public ShipmentStatusSoldProducts getCountOfSoldProductsByShipmentStatus() {
		return inventoryRepository.findSoldProductsByShipmentStatus();
	}
}