package com.example.template.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TrainDTO {

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
	private int duration;

	@NotNull
	private int distance;

	private Double fare;
	private Integer seatsAvailable;

	public TrainDTO(Long id, int number, String name, String departureStation, LocalDateTime departureTime,
			String arrivalStation, LocalDateTime arrivalTime, int duration, int distance, Double fare,
			Integer seatsAvailable) {
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
	public TrainDTO(){
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

	public void setNumber(int number) {
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

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
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
