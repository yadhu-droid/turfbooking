package com.turf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turf.entity.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long> {

	static Payment findByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
