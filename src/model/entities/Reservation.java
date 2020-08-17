package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber = 0;
	private LocalDate checkIn = null;
	private LocalDate checkOut = null;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		
		if (checkOut.isBefore(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
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
	
	// Duração
	public long duration() {
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	// Atualiza Dados
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (checkOut.isBefore(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", checkIn: " + dtf.format(checkIn) 
				+ ", checkOut: " + dtf.format(checkOut)
				+ ", " + duration() + " nights";
	}
	
	
}
