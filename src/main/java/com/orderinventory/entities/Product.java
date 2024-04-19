
package com.orderinventory.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "colour",length = 45, nullable = false)
    private String colour;
    
    @Column(name = "brand",length = 45, nullable = false)
    private String brand;
    
    
    @Column(name = "size",length = 10, nullable = false)
    private String size;
    
    @Column(name = "rating", nullable = false)
    private int rating;
    
    public Product() {}
	
	public Product(int productId, String productName, BigDecimal unitPrice, String colour, String brand, String size,
			int rating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.colour = colour;
		this.brand = brand;
		this.size = size;
		this.rating = rating;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
    
}
