package entities;

import java.sql.Time;
import java.time.LocalDateTime;

public class Flight {

	private int flightNumber;
	
	private Time departureTime;
	
	private Time arrivalTime;
	
	private double economyPrice;
	
	private double businessPrice;
	
	private Airport departureAirport;
	
	private Airport arrivalAirport;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(double economyPrice) {
		this.economyPrice = economyPrice;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	
}
