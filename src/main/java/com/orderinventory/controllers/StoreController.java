
package com.orderinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Store;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.StoreServices;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

	@Autowired
	private StoreServices store;

	@GetMapping
	public ResponseEntity<List<Store>> getAllStores() {
		List<Store> stores = store.getAllStores();

		if (stores.isEmpty()) {
			throw new NotFoundException("No stores found");
		}

		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Store> getStoreById(@PathVariable("id") int storeId){
		return new ResponseEntity<Store>(store.getStoreById(storeId),HttpStatus.OK);
	}

}
