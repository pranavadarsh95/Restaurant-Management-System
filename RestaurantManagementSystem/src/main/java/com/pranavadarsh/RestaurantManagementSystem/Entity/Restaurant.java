package com.pranavadarsh.RestaurantManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pranavadarsh.RestaurantManagementSystem.Exception.TableUnAvailableException;

import static com.pranavadarsh.RestaurantManagementSystem.Common.ResponseEnum.*;

@Entity
@Table(name="restaurant")
public class Restaurant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	 @Column(name = "CONTACT_NUMBER", unique = true, nullable = false)
	private String contactNumber;
	
	@Column(name="available_table_count", unique = true, nullable = false)
	private int availableTableCount; 
	
	@Column(name="opening_hour")
	private int openingHour;
	
	@Column(name="closing_hour")
	private int closingHour;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	

	public Restaurant() {
		
	}

	
	
	
	public Restaurant(String name, String contactNumber,int availableTableCount,int openingHour, int closingHour,
			String latitude, String longitude, String address1, String address2) {
		
		this.name = name;
		this.contactNumber = contactNumber;
		this.availableTableCount = availableTableCount;
		this.openingHour = openingHour;
		this.closingHour = closingHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address1 = address1;
		this.address2 = address2;
		this.isActive=true;// If restaurant is getting added means it is open to accept order we can further change it.
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getAvailableTableCount() {
		return availableTableCount;
	}

	public void setAvailableTableCount(int availableTableCount) {
		this.availableTableCount = availableTableCount;
	}

	public int getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(int openingHour) {
		this.openingHour = openingHour;
	}

	public int getClosingHour() {
		return closingHour;
	}


	public void setClosingHour(int closingHour) {
		this.closingHour = closingHour;
	}


	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}




	public int isTableAvailable(int requestedTableCount) {
		
		if(requestedTableCount<=0)
			throw new TableUnAvailableException(ENTERED_VALUE_ISWRONG.getMessage());
		
        boolean result = (availableTableCount >= requestedTableCount);
        System.out.println("Inside Restaurant isTableAvailable and availableTableCount - requestedTableCount => "+(availableTableCount - requestedTableCount));
        if(result) 
        blockAvailableTableCount(requestedTableCount);
        
        else
        {
        		return availableTableCount;
        }
        return Integer.MAX_VALUE;//just to say yes demanded number of tables can be allocated
    }

    public void blockAvailableTableCount(int requestedTableCount) {
    	System.out.println("inside blockAvailableTableCount and requestedTableCount => "+ requestedTableCount);
    	System.out.println("inside blockAvailableTableCount and before availableTableCount => "+ availableTableCount);
    	availableTableCount -= requestedTableCount;
    	System.out.println("inside blockAvailableTableCount and Updated availableTableCount => "+ availableTableCount);
     
    }

    public void freeAvailableTableCount(int freeTableCount) {
    	System.out.println("inside freeAvailableTableCount and freeTableCount => "+ availableTableCount);
    	System.out.println("inside freeAvailableTableCount and before availableTableCount => "+ availableTableCount);
    	availableTableCount += freeTableCount;
    	System.out.println("inside freeAvailableTableCount and Updated availableTableCount => "+ availableTableCount);
      
    }
	
	
}
