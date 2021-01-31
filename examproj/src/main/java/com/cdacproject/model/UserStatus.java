package com.cdacproject.model;

public class UserStatus {
	
	private String status;

	public UserStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserStatus(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserStatus [status=" + status + "]";
	}
	
	

}
