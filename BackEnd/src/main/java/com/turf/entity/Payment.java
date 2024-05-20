package com.turf.entity;

import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	private String cardNumber;
	private YearMonth month;
	private String customerName;
	private String securityCode;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Payment(long paymentId, String cardNumber, YearMonth month, String customerName, String securityCode,
			User user) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
		this.month = month;
		this.customerName = customerName;
		this.securityCode = securityCode;
		this.user = user;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
