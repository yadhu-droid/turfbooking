package com.turf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turf.dto.BookSlotDTO;
import com.turf.dto.LoginDTO;
import com.turf.dto.PaymentDTO;
import com.turf.dto.UserDTO;
import com.turf.entity.BookedSlots;
import com.turf.entity.Payment;
import com.turf.entity.User;
import com.turf.service.BookingService;
import com.turf.service.UserService;

@RestController
@RequestMapping(value="/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/add") 
	public int addUser(@RequestBody UserDTO userDto) {
		return userService.addUser(userDto);
	}
	
	@PostMapping("/login")
	public User validateUser(@RequestBody LoginDTO loginDto) {
		return userService.validateUser(loginDto);
	}
	
	@PostMapping("/verifyslot")
	public boolean verifySlot(@RequestBody BookSlotDTO bookSlotDto) {
		return bookingService.verifySlot(bookSlotDto);
	}
	
	@PostMapping("/bookslot") 
	public int bookSlot(@RequestBody BookSlotDTO bookSlotDto) {
		return bookingService.addBookingSlot(bookSlotDto);
	}
	
	@GetMapping("/getbookingdetails/{userId}")
	public List<BookedSlots> getBookingDetails(@PathVariable long userId){
		return bookingService.getBookingDetails(userId);
	}
	
	@PostMapping("/payment") 
	public Payment payment(@RequestBody PaymentDTO paymentDto) {
		return bookingService.addPayment(paymentDto);
	}
	
}
