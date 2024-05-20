package com.turf.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turf.entity.BookedSlots;

@Repository
public interface BookingDao extends JpaRepository<BookedSlots, Long> {
	
	@Query(value="SELECT * FROM booked_slots WHERE user_id =:userId",nativeQuery = true)
	List<BookedSlots> findBookingByUserId(long userId);

	@Query(value="SELECT COUNT(*) FROM booked_slots where slot_date =:parsedDate AND slot_time =:parsedTime",nativeQuery = true)
	int slotAlreadyBooked(LocalDate parsedDate, LocalTime parsedTime);

}
