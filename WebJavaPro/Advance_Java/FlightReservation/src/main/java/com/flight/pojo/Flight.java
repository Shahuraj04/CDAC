package com.flight.pojo;

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
	private Time departure_time;
	private Time arrival_time;
	private int no_of_stops;
	private double price;

	public Flight(int flight_id, Airline airline, Source source, Destination destination, Date departure_date,
			Time departure_time, double price) {
		super();
		this.flight_id = flight_id;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departure_date = departure_date;
		this.departure_time = departure_time;
		this.price = price;
	}

	public Flight(Source source, Destination destination, Date departure_date) {
		super();
		this.source = source;
		this.destination = destination;
		this.departure_date = departure_date;
	}

}
