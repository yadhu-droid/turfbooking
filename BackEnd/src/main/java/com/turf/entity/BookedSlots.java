package com.turf.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booked_slots")
public class BookedSlots {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	
	
	public BookedSlots(long bookingId, User user, Payment payment, LocalDate slotDate, LocalTime slotTime,
			LocalDateTime currentDateAndTime) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.payment = payment;
		this.slotDate = slotDate;
		this.slotTime = slotTime;
		this.currentDateAndTime = currentDateAndTime;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	private LocalDate slotDate;
	private LocalTime slotTime;
	private LocalDateTime currentDateAndTime;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}
	public LocalTime getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(LocalTime slotTime) {
		this.slotTime = slotTime;
	}
	public LocalDateTime getCurrentDateAndTime() {
		return currentDateAndTime;
	}
	public void setCurrentDateAndTime(LocalDateTime currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookedSlots() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
