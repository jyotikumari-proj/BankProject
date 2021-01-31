package com.cdacproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressId")
	private int addressId;
	
	 @Column(name = "houseNo")  
    private String houseNo;
	 
	 @Column(name = "location")   
    private String location;
	 
	 @Column(name = "city")    
    private String city;
	 
	 @Column(name = "state")   
    private String state;
	 
	 @Column(name = "pin") 
    private String pin;
    
    @OneToOne(mappedBy = "address")
    private User user;
    
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String houseNo, String location, String city, String state, String pin) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", location=" + location + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + "]";
	}
    
	
   

}
