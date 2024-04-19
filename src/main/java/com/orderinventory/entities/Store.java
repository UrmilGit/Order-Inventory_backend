
package com.orderinventory.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.util.Date;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "stores",
uniqueConstraints = {@UniqueConstraint(name = "store_name_u", columnNames = {"store_name"})})
@Check(name="store_at_least_one_address_c",constraints = "web_address IS NOT NULL OR physical_address IS NOT NULL")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "store_name", nullable = false, unique = true)
    private String storeName;

    @Column(name = "web_address", length = 100)
    private String webAddress;

    @Column(name = "physical_address", length = 512)
    private String physicalAddress;

    @Column(name = "latitude", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "logo_mime_type", length = 512)
    private String logoMimeType;

    @Column(name = "logo_filename", length = 512)
    private String logoFilename;

    @Column(name = "logo_charset", length = 512)
    private String logoCharset;

    @Temporal(TemporalType.DATE)
    @Column(name = "logo_last_updated")
    private Date logoLastUpdated;

    
    public Store() {
        // Default constructor
    }


    
	public Store(int storeId, String storeName, String webAddress, String physicalAddress, BigDecimal latitude,
			BigDecimal longitude, String logoMimeType, String logoFilename, String logoCharset,
			Date logoLastUpdated) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.webAddress = webAddress;
		this.physicalAddress = physicalAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.logoMimeType = logoMimeType;
		this.logoFilename = logoFilename;
		this.logoCharset = logoCharset;
		this.logoLastUpdated = logoLastUpdated;
	}


	
    public int getStoreId() {
        return storeId;
    }


	
    public void setStoreId(int storeId) {
        this.storeId = storeId;
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

    
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    
    public BigDecimal getLatitude() {
        return latitude;
    }

    
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    
    public BigDecimal getLongitude() {
        return longitude;
    }

    
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }



    
    public String getLogoMimeType() {
        return logoMimeType;
    }

    
    public void setLogoMimeType(String logoMimeType) {
        this.logoMimeType = logoMimeType;
    }

    
    public String getLogoFilename() {
        return logoFilename;
    }

    
    public void setLogoFilename(String logoFilename) {
        this.logoFilename = logoFilename;
    }

   
    public String getLogoCharset() {
        return logoCharset;
    }

    
    public void setLogoCharset(String logoCharset) {
        this.logoCharset = logoCharset;
    }

   
    public Date getLogoLastUpdated() {
        return logoLastUpdated;
    }

    
    public void setLogoLastUpdated(Date logoLastUpdated) {
        this.logoLastUpdated = logoLastUpdated;
    }
}
