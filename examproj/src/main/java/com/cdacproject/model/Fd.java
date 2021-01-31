package com.cdacproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fd")
public class Fd {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fdId")
	private int fdId;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "depositAmount")
	private String depositAmount;
	
	@Column(name = "period")
	private String period;
	
	@Column(name = "dateOfBooking")
	private String dateOfBooking;
	
	@Column(name = "dateOfMaturity")
	private String dateOfMaturity;
	
	@Column(name = "nomineeName")
	private String nomineeName;
	
	@Column(name = "relationWithNominee")
	private String relationWithNominee;
	
	@Column(name = "interestRate")
	private String interestRate;

	@Column(name = "interestAmount")
	private String interestAmount;
	
	@Column(name = "MaturityAmount")
	private String MaturityAmount;

	public Fd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fd(int fdId, String userId, String depositAmount, String period, String dateOfBooking, String dateOfMaturity,
			String nomineeName, String relationWithNominee, String interestRate, String interestAmount,
			String maturityAmount) {
		super();
		this.fdId = fdId;
		this.userId = userId;
		this.depositAmount = depositAmount;
		this.period = period;
		this.dateOfBooking = dateOfBooking;
		this.dateOfMaturity = dateOfMaturity;
		this.nomineeName = nomineeName;
		this.relationWithNominee = relationWithNominee;
		this.interestRate = interestRate;
		this.interestAmount = interestAmount;
		MaturityAmount = maturityAmount;
	}

	public int getFdId() {
		return fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getDateOfMaturity() {
		return dateOfMaturity;
	}

	public void setDateOfMaturity(String dateOfMaturity) {
		this.dateOfMaturity = dateOfMaturity;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getRelationWithNominee() {
		return relationWithNominee;
	}

	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(String interestAmount) {
		this.interestAmount = interestAmount;
	}

	public String getMaturityAmount() {
		return MaturityAmount;
	}

	public void setMaturityAmount(String maturityAmount) {
		MaturityAmount = maturityAmount;
	}

	@Override
	public String toString() {
		return "Fd [fdId=" + fdId + ", userId=" + userId + ", depositAmount=" + depositAmount + ", period=" + period
				+ ", dateOfBooking=" + dateOfBooking + ", dateOfMaturity=" + dateOfMaturity + ", nomineeName="
				+ nomineeName + ", relationWithNominee=" + relationWithNominee + ", interestRate=" + interestRate
				+ ", interestAmount=" + interestAmount + ", MaturityAmount=" + MaturityAmount + "]";
	}
	
	
}
