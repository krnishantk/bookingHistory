package com.carwash.bookingHistory.resource;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.bookingHistory.model.BookingHistory;
import com.carwash.bookingHistory.model.RestResponse;
import com.carwash.bookingHistory.service.BookingHistoryService;

@RequestMapping("bookingHistory")
@RestController
@CrossOrigin
public class BookingHistoryResource {

	@Autowired
	private BookingHistoryService bookingHistoryService;

	@PostMapping()
	public RestResponse addNewBooking(@RequestBody BookingHistory bookingHistory) {
		RestResponse response = new RestResponse();
		BookingHistory newBookingHistory = bookingHistoryService.saveBooking(bookingHistory);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("orderPalceId", newBookingHistory.getId());
		response.setData(responseMap);
		response.setMsg("new order place successfully");

		return response;
	}

	@PutMapping("assignCarWasher")
	public RestResponse assignCarWasher(@RequestBody BookingHistory bookingHistory) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService
				.getBookingHistoryByBookingNumber(bookingHistory.getBookingNumber());
		if (isBookingHistory != null) {
			BookingHistory assignedCarWash = bookingHistoryService.assignCarWasher(isBookingHistory,
					bookingHistory.getWasherName());
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("assigned", assignedCarWash.getWasherName());
			response.setData(responseMap);
			response.setMsg("successfully assigned the car washer");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

	@GetMapping("bookingOrderCompleted/{bookingNumber}")
	public RestResponse getBookingOrderCompleted(@PathVariable String bookingNumber) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService.getBookingHistoryByBookingNumber(bookingNumber);
		if (isBookingHistory != null) {
			BookingHistory assignedCarWash = bookingHistoryService.bookingOrderCompleted(isBookingHistory);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("assigned", assignedCarWash.getWasherName());
			response.setData(responseMap);
			response.setMsg("booking number status changed in completed");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

	@GetMapping("bookingOrderRejected/{bookingNumber}")
	public RestResponse getBookingOrderRejected(@PathVariable String bookingNumber) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService.getBookingHistoryByBookingNumber(bookingNumber);
		if (isBookingHistory != null) {
			BookingHistory assignedCarWash = bookingHistoryService.bookingOrderRejected(isBookingHistory);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("assigned", assignedCarWash.getWasherName());
			response.setData(responseMap);
			response.setMsg("booking number status changed in rejected");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

	@GetMapping("{bookingNumber}")
	public RestResponse getAllBookingHistory(@PathVariable String bookingNumber) {
		RestResponse response = new RestResponse();
		BookingHistory bookingHistoryByBookingNumber = bookingHistoryService
				.getBookingHistoryByBookingNumber(bookingNumber);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("bookingHistory", bookingHistoryByBookingNumber);
		response.setData(responseMap);
		response.setMsg("get booking history by booking number successfully");
		return response;
	}

	@GetMapping("getAll")
	public List<BookingHistory> getAllBookingHistory() {
		RestResponse response = new RestResponse();

		List<BookingHistory> allBookingHistory = bookingHistoryService.getAllBookingHistory();
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("orderPalceId", allBookingHistory);
		response.setData(responseMap);
		response.setMsg("get all booking history successfully");

		return allBookingHistory;
	}

	@GetMapping("getAll/customer/{userId}")
	public List<BookingHistory> getAllBookingHistoryByCustomerId(@PathVariable String userId) {
		RestResponse response = new RestResponse();

		List<BookingHistory> allBookingHistoryByCustomerId = bookingHistoryService
				.getAllBookingHistoryByCustomerId(userId);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("orderPalceId", allBookingHistoryByCustomerId);
		response.setData(responseMap);
		response.setMsg("get all booking history by customer id successfully");

		return allBookingHistoryByCustomerId;
	}

	@GetMapping("getAll/washer/{userId}")
	public List<BookingHistory> getAllBookingHistoryByWasherId(@PathVariable String userId) {
		RestResponse response = new RestResponse();

		List<BookingHistory> allBookingHistoryByWasherId = bookingHistoryService.getAllBookingHistoryByWasherId(userId);
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("orderPalceId", allBookingHistoryByWasherId);
		response.setData(responseMap);
		response.setMsg("get all booking history by washer id successfully");

		return allBookingHistoryByWasherId;
	}

	@GetMapping("carWasherAcceptedOrder/{bookingNumber}")
	public RestResponse carWasherAcceptedOrder(@PathVariable String bookingNumber) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService.getBookingHistoryByBookingNumber(bookingNumber);
		if (isBookingHistory != null) {
			BookingHistory assignedCarWash = bookingHistoryService.getCarWasherAcceptedOrder(isBookingHistory);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("assigned", assignedCarWash.getWasherName());
			response.setData(responseMap);
			response.setMsg("booking number status changed in InProcess");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

	@GetMapping("carWasherRejectedOrder/{bookingNumber}")
	public RestResponse carWasherRejectedOrder(@PathVariable String bookingNumber) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService.getBookingHistoryByBookingNumber(bookingNumber);
		if (isBookingHistory != null) {
			BookingHistory assignedCarWash = bookingHistoryService.getCarWasherRejectedOrder(isBookingHistory);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("assigned", assignedCarWash.getWasherName());
			response.setData(responseMap);
			response.setMsg("booking number status changed in rejected");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

	@PutMapping("addingRatingAndComments/{bookingNumber}")
	public RestResponse addingRatingAndComments(@PathVariable String bookingNumber,
			@RequestBody BookingHistory bookingHistory) {
		RestResponse response = new RestResponse();
		BookingHistory isBookingHistory = bookingHistoryService.getBookingHistoryByBookingNumber(bookingNumber);
		if (isBookingHistory != null) {
			isBookingHistory.setCustomerRatings(bookingHistory.getCustomerRatings());
			isBookingHistory.setCustomerReviews(bookingHistory.getCustomerReviews());
			bookingHistoryService.addingRatingAndComments(isBookingHistory);
			HashMap<String, Object> responseMap = new HashMap<>();
			responseMap.put("bookingNumber", isBookingHistory.getBookingNumber());
			response.setData(responseMap);
			response.setMsg("rating and comments added successfully");
		} else {
			response.setMsg("booking number does not available");
		}
		return response;
	}

}
