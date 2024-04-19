package com.orderinventory.dto;
 
import com.orderinventory.entities.Store;
import java.util.*;
import java.util.stream.Collectors;
 
public class StoreDTO {
    private int id;
    private String storeName;
    private String webAddress;
 
    // Constructor, getters, and setters
    
 
    public static StoreDTO fromEntity(Store store) {
        StoreDTO dto = new StoreDTO();
        dto.setId(store.getStoreId());
        dto.setStoreName(store.getStoreName());
        dto.setWebAddress(store.getWebAddress());
        return dto;
    }
 
    public static List<StoreDTO> fromEntities(List<Store> stores) {
        return stores.stream()
                .map(StoreDTO::fromEntity)
                .collect(Collectors.toList());
    }
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getStoreName() {
		return storeName;
	}
 
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
 
	public String getWebAddress() {
		return webAddress;
	}
 
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
}
