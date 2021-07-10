/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busbookingsystem;

import java.io.Serializable;

/**
 *
 * @author SuongNTM
 */
public class Bus implements Serializable{

    private String bcode;
    private String busName;
    private Integer seat;
    private Integer booked;
    private double departTime;
    private double arrivalTime;
    public static final long serialVersionUID = 1L;

    public Bus() {
        
    }

    public Bus(String bcode, String busName, Integer seat, Integer booked, double departTime, double arrivalTime) {
        this.bcode = bcode;
        this.busName = busName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getBooked() {
        return booked;
    }

    public void setBooked(Integer booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return String.format("%-5s|%-5s|%-5d|%-5d|%-5.1f|%-5.1f\n", bcode, busName, seat, booked, departTime, arrivalTime);
    }

    
}
