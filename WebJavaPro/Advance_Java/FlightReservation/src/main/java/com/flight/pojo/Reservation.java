package com.flight.pojo;

import java.sql.Date;

public class Reservation {

    private int reservation_id;
    private static int counter = 1;  
    private Date reservation_date;
    private String passenger_email;
    private String passenger_f_name;
    private String passenger_l_name;
    private String passenger_phNo;
    private String status;
    private int flight_id;

 
    public Reservation() {
        this.reservation_id = counter++;
    }

    
    public Reservation(Date reservation_date, String passenger_email, String passenger_f_name,
                       String passenger_l_name, String passenger_phNo, String status, int flight_id) {
        this.reservation_id = counter++;
        this.reservation_date = reservation_date;
        this.passenger_email = passenger_email;
        this.passenger_f_name = passenger_f_name;
        this.passenger_l_name = passenger_l_name;
        this.passenger_phNo = passenger_phNo;
        this.status = status;
        this.flight_id = flight_id;
    }

 
    public int getReservation_id() {
        return reservation_id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getPassenger_email() {
        return passenger_email;
    }

    public void setPassenger_email(String passenger_email) {
        this.passenger_email = passenger_email;
    }

    public String getPassenger_f_name() {
        return passenger_f_name;
    }

    public void setPassenger_f_name(String passenger_f_name) {
        this.passenger_f_name = passenger_f_name;
    }

    public String getPassenger_l_name() {
        return passenger_l_name;
    }

    public void setPassenger_l_name(String passenger_l_name) {
        this.passenger_l_name = passenger_l_name;
    }

    public String getPassenger_phNo() {
        return passenger_phNo;
    }

    public void setPassenger_phNo(String passenger_phNo) {
        this.passenger_phNo = passenger_phNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", reservation_date=" + reservation_date
                + ", passenger_email=" + passenger_email + ", passenger_f_name=" + passenger_f_name
                + ", passenger_l_name=" + passenger_l_name + ", passenger_phNo=" + passenger_phNo + ", status="
                + status + ", flight_id=" + flight_id + "]";
    }
}
