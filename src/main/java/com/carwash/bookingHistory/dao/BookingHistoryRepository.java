package com.carwash.bookingHistory.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.bookingHistory.model.BookingHistory;

@Repository
public interface BookingHistoryRepository  extends MongoRepository<BookingHistory, String> {
	
	List<BookingHistory> findByCustomerName(String customerId);
	
	BookingHistory findByBookingNumber(String bookingNumber);

	List<BookingHistory> findByWasherName(String washerId);

}
