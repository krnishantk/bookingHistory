package com.carwash.bookingHistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.bookingHistory.dao.BookingHistoryRepository;
import com.carwash.bookingHistory.model.BookingHistory;

@Service
public class BookingHistoryService {

	@Autowired
	private BookingHistoryRepository bookingHistoryRepository;

	public BookingHistory saveBooking(BookingHistory bookingHistory) {
		bookingHistory.setStatus("New");
		bookingHistory.setPaymentStatus("Pending");
		bookingHistory.setBookingNumber("" + bookingHistoryRepository.findAll().size() + 1);
		return bookingHistoryRepository.save(bookingHistory);
	}

	public List<BookingHistory> getAllBookingHistory() {
		return bookingHistoryRepository.findAll();
	}

	public List<BookingHistory> getAllBookingHistoryByCustomerId(String customerId) {
		return bookingHistoryRepository.findByCustomerName(customerId);
	}

	public BookingHistory getBookingHistoryByBookingNumber(String bookingNumber) {
		return bookingHistoryRepository.findByBookingNumber(bookingNumber);
	}

	public BookingHistory assignCarWasher(BookingHistory bookingHistory, String washerName) {
		bookingHistory.setWasherName(washerName);
		bookingHistory.setStatus("Assigned");
		return bookingHistoryRepository.save(bookingHistory);
	}

	public BookingHistory bookingOrderRejected(BookingHistory bookingHistory) {
		bookingHistory.setStatus("Rejected");
		return bookingHistoryRepository.save(bookingHistory);
	}

	public BookingHistory bookingOrderCompleted(BookingHistory bookingHistory) {
		bookingHistory.setStatus("Completed");
		bookingHistory.setPaymentStatus("Success");
		return bookingHistoryRepository.save(bookingHistory);
	}

	public List<BookingHistory> getAllBookingHistoryByWasherId(String washerId) {
		return bookingHistoryRepository.findByWasherName(washerId);
	}

	public BookingHistory getCarWasherAcceptedOrder(BookingHistory isBookingHistory) {
		isBookingHistory.setStatus("InProcess");
		return bookingHistoryRepository.save(isBookingHistory);
	}

	public BookingHistory getCarWasherRejectedOrder(BookingHistory isBookingHistory) {
		isBookingHistory.setStatus("New");
		isBookingHistory.setWasherName("");
		return bookingHistoryRepository.save(isBookingHistory);
	}

	public BookingHistory addingRatingAndComments(BookingHistory isBookingHistory) {
		return bookingHistoryRepository.save(isBookingHistory);
	}

}
