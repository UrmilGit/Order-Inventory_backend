
package com.orderinventory.dto;

public class ProdBrandCount {
	private int Id;
	private Long count;
	
	public ProdBrandCount(int id, Long count) {
		super();
		Id = id;
		this.count = count;
	}
	
	public ProdBrandCount() {
		super();
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void setCount(Long count) {
		this.count = count;
	}
}
