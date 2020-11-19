package com.carwash.bookingHistory.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class BookingHistory {

	@Id
	private String id;

	private String bookingNumber;

	@NotBlank(message = "vehicleNumber cannot be empty")
	private String vehicleNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotBlank(message = "serviceDate cannot be empty")
	private Date serviceDate;

	@NotBlank(message = "carType cannot be empty")
	private String carType;

	@NotBlank(message = "packageName cannot be empty")
	private String packageName;

	@NotBlank(message = "packageRate cannot be empty")
	private Double packageRate;

	private String addOnName;

	private Double addOnRate;

	private Double total;

	private String customerName;

	private String washerName;

	private String status;

	private String paymentStatus;

	private String customerReviews;

	private int customerRatings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Double getPackageRate() {
		return packageRate;
	}

	public void setPackageRate(Double packageRate) {
		this.packageRate = packageRate;
	}

	public String getAddOnName() {
		return addOnName;
	}

	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}

	public Double getAddOnRate() {
		return addOnRate;
	}

	public void setAddOnRate(Double addOnRate) {
		this.addOnRate = addOnRate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getCustomerReviews() {
		return customerReviews;
	}

	public void setCustomerReviews(String customerReviews) {
		this.customerReviews = customerReviews;
	}

	public int getCustomerRatings() {
		return customerRatings;
	}

	public void setCustomerRatings(int customerRatings) {
		this.customerRatings = customerRatings;
	}

	@Override
	public String toString() {
		return "BookingHistory [id=" + id + ", bookingNumber=" + bookingNumber + ", vehicleNumber=" + vehicleNumber
				+ ", serviceDate=" + serviceDate + ", carType=" + carType + ", packageName=" + packageName
				+ ", packageRate=" + packageRate + ", addOnName=" + addOnName + ", addOnRate=" + addOnRate + ", total="
				+ total + ", customerName=" + customerName + ", washerName=" + washerName + ", status=" + status
				+ ", paymentStatus=" + paymentStatus + ", customerReviews=" + customerReviews + ", customerRatings="
				+ customerRatings + "]";
	}

}
