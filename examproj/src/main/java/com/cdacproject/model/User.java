package com.cdacproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(name = "userId")
	private String userId;
	
	 @Column(name = "name")
	private String name;
	 
	 @Column(name = "password")
	private String password;
	 
	 @Column(name = "branch_Name") 
	private final String branch_Name="HAL"; 
	
	 @Column(name = "aadhar") 
	private String aadhar;
	 
	 @Column(name = "pan")  
	private String pan;
	 
	 @Column(name = "accountType") 
	private String accountType;
	 
	 @Column(name = "IFSC_Code") 
	private final String IFSC_Code="APNA0473000";
	 
	 @Column(name = "mobile")  
	private String mobile;
	 
	 @Column(name = "branchCode")  
	private  final String branchCode="473000";
	 
	 @Column(name = "userType") 
	private String userType;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "accountId", referencedColumnName = "accountId")
	 private Account account;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userId, String name, String password, String aadhar, String pan,
			String accountType, String mobile, String userType, Address address,Account account ) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.aadhar = aadhar;
		this.pan = pan;
		this.accountType = accountType;
		this.mobile = mobile;
		this.userType = userType;
		this.address = address;
		this.account=account;
	}
	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBranch_Name() {
		return branch_Name;
	}

	public String getIFSC_Code() {
		return IFSC_Code;
	}

	public String getBranchCode() {
		return branchCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", name=" + name + ", password=" + password + ", branch_Name="
				+ branch_Name + ", aadhar=" + aadhar + ", pan=" + pan + ", accountType=" + accountType + ", IFSC_Code="
				+ IFSC_Code + ", mobile=" + mobile + ", branchCode=" + branchCode + ", userType=" + userType
				+ ", address=" + address + ", account=" + account + "]";
	}

	
	

}
