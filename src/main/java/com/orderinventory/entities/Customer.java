package com.orderinventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    public Customer() {}

    
    public Customer(String emailAddress, String fullName) {
        this.emailAddress = emailAddress;
        this.fullName = fullName;
    }
    

    
	public Customer(int customerId, String emailAddress, String fullName) {
		super();
		this.customerId = customerId;
		this.emailAddress = emailAddress;
		this.fullName = fullName;
	}

	
    public int getCustomerId() {
        return customerId;
    }

    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
    public String getEmailAddress() {
        return emailAddress;
    }

    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    
    public String getFullName() {
        return fullName;
    }

    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}