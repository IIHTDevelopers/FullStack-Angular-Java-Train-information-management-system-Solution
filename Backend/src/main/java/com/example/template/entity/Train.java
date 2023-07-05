package com.example.template.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Integer number;

	@NotNull
	@Size(min = 3, max = 100)
	private String name;

	@NotNull
	private String departureStation;

	@NotNull
	private String arrivalStation;

	@NotNull
	private Integer duration;

	@NotNull
	private Integer distance;

	private Double fare;

	private Integer seatsAvailable;

	public Train(Long id, @NotNull Integer number, @NotNull @Size(min = 3, max = 100) String name,
			@NotNull String departureStation, @NotNull LocalDateTime departureTime, @NotNull String arrivalStation,
			@NotNull LocalDateTime arrivalTime, @NotNull Integer duration, @NotNull Integer distance, Double fare,
			Integer seatsAvailable) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.duration = duration;
		this.distance = distance;
		this.fare = fare;
		this.seatsAvailable = seatsAvailable;
	}

	public Train() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

}
