package com.lti.model;

import java.time.LocalTime;

import javax.persistence.Entity;import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TBL_STOP")
public class Stop {

	@Id
	@GeneratedValue
	private int stopNo;
	private String name;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	
	@ManyToOne
	@JoinColumn(name = "BUS_ID")
	private Bus bus;


	public int getStopNo() {
		return stopNo;
	}


	public void setStopNo(int stopNo) {
		this.stopNo = stopNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public LocalTime getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
}
