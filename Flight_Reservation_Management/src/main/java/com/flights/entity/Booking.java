package com.flights.entity;

import java.time.LocalDate;

public class Booking {
	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", flightId=" + flightId + ", bookingDate=" + bookingDate
				+ "]";
	}

	private int id;
	private int userId;
	private int flightId;
	private LocalDate bookingDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Booking(int id, int userId, int flightId, LocalDate bookingDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

}
