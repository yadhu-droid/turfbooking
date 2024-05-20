package com.turf.dto;

import java.time.YearMonth;

public class PaymentDTO {
	
	private String cardNumber;
	private YearMonth month;
	private String customerName;
	private String securityCode;
	private int userId;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public YearMonth getMonth() {
		return month;
	}
	public void setMonth(YearMonth month) {
		this.month = month;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public PaymentDTO(String cardNumber, YearMonth month, String customerName, String securityCode, int userId) {
		super();
		this.cardNumber = cardNumber;
		this.month = month;
		this.customerName = customerName;
		this.securityCode = securityCode;
		this.userId = userId;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
