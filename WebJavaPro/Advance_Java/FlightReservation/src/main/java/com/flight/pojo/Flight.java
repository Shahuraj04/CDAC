package com.flight.pojo;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class Flight {
	// | flight_id | airline | source | destination | departure_date | arrival_date
	// | departure_time | arrival_time | no_of_stops | price

	private int flight_id;
	private Airline airline;
	private Source source;
	private Destination destination;
	private Date departure_date;
	private Date arrival_date;
	private java.sql.Timestamp departure_time;
	private java.sql.Timestamp arrival_time;
	private int no_of_stops;
	private double price;

	public Flight(int flight_id, Airline airline, Source source, Destination destination, Date departure_date,
			java.sql.Timestamp departure_time, double price) {
		super();
		this.flight_id = flight_id;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departure_date = departure_date;
		this.departure_time = departure_time;
		this.price = price;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public java.sql.Timestamp getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(java.sql.Timestamp departure_time) {
		this.departure_time = departure_time;
	}

	public java.sql.Timestamp getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(java.sql.Timestamp arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getNo_of_stops() {
		return no_of_stops;
	}

	public void setNo_of_stops(int no_of_stops) {
		this.no_of_stops = no_of_stops;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", departure_date=" + departure_date + ", arrival_date=" + arrival_date
				+ ", departure_time=" + departure_time + ", arrival_time=" + arrival_time + ", no_of_stops="
				+ no_of_stops + ", price=" + price + "]";
	}

	public Flight(Source source, Destination destination, Date departure_date) {
		super();
		this.source = source;
		this.destination = destination;
		this.departure_date = departure_date;
	}

}
