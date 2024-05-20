package com.turf.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turf.dao.BookingDao;
import com.turf.dao.PaymentDao;
import com.turf.dao.UserDao;
import com.turf.dto.BookSlotDTO;
import com.turf.dto.PaymentDTO;
import com.turf.entity.BookedSlots;
import com.turf.entity.Payment;
import com.turf.entity.User;

@Service
public class BookingService {
	
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PaymentDao paymentDao;

	public int addBookingSlot(BookSlotDTO bookSlotDto) {
		
		// Define the date and time formatters
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse the date and time strings to LocalDate and LocalTime
        LocalDate parsedDate = LocalDate.parse(bookSlotDto.getDate(), dateFormatter);
        LocalTime parsedTime = LocalTime.parse(bookSlotDto.getTime(), timeFormatter);
     
        	LocalDateTime currentDateTime = LocalDateTime.now();
            
            BookedSlots bookedSlots = new BookedSlots();
            
            User user = userDao.findByUserId(bookSlotDto.getUserId());
            
            Payment payment = PaymentDao.findByPaymentId(bookSlotDto.getPaymentId());
            
            bookedSlots.setSlotDate(parsedDate);
            bookedSlots.setSlotTime(parsedTime);
            bookedSlots.setCurrentDateAndTime(currentDateTime);
            bookedSlots.setUser(user);
            bookedSlots.setPayment(payment);
            
            bookingDao.save(bookedSlots);
            return 1;        
	}

	public List<BookedSlots> getBookingDetails(long userId) {
		return bookingDao.findBookingByUserId(userId);
	}

	public boolean verifySlot(BookSlotDTO bookSlotDto) {
		// Define the date and time formatters
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse the date and time strings to LocalDate and LocalTime
        LocalDate parsedDate = LocalDate.parse(bookSlotDto.getDate(), dateFormatter);
        LocalTime parsedTime = LocalTime.parse(bookSlotDto.getTime(), timeFormatter);
        
        int slotAlreadyBooked = bookingDao.slotAlreadyBooked(parsedDate, parsedTime);
        
        if(slotAlreadyBooked>0) {
        	return false;
        }
        else {
        	return true;
        }
	}

	public Payment addPayment(PaymentDTO paymentDto) {
		Payment payment = new Payment();
		payment.setCardNumber(paymentDto.getCardNumber());
		payment.setCustomerName(paymentDto.getCustomerName());
		payment.setMonth(paymentDto.getMonth());
		payment.setSecurityCode(paymentDto.getSecurityCode());
		User user = userDao.findByUserId(paymentDto.getUserId());
		payment.setUser(user);
		Payment savedPayment = paymentDao.save(payment);
		return savedPayment;
	}
	
}
