package com.flight.pojo;

public enum Airline {
	INDIGO, AIRINDIA, SPICEJET, VISTARA, GOFIRST;
	
	@Override
	public String toString() {
		return name();
	}

}
