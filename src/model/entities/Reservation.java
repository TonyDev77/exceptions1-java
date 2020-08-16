package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber = 0;
	private LocalDate checkIn = null;
	private LocalDate checkOut = null;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCeckIn() {
		return checkIn;
	}

	public LocalDate getCeckOut() {
		return checkOut;
	}
	
	//...
	public Period duration() {
		return Period.between(checkIn, checkOut);
	}
	
	//...
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", checkIn: " + dtf.format(checkIn) 
				+ ", checkOut: " + dtf.format(checkOut)
				+ ", " + duration().getDays() + " nights";
	}
	
	
}
