package com.example.template.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.template.dto.TrainDTO;
import com.example.template.entity.Train;
import com.example.template.service.TrainService;

@RestController
@RequestMapping("/trains")
@CrossOrigin
public class TrainController {
	private final TrainService trainService;

	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}

	@PostMapping
	public ResponseEntity<Train> createTrain(@Valid @RequestBody TrainDTO trainDTO) {
		Train createdTrain = trainService.createTrain(trainDTO);
		return new ResponseEntity<>(createdTrain, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Train> updateTrain(@PathVariable Long id, @Valid @RequestBody TrainDTO trainDTO) {
		Train updatedTrain = trainService.updateTrain(id, trainDTO);
		return ResponseEntity.ok(updatedTrain);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
		trainService.deleteTrain(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
		Train train = trainService.getTrainById(id);
		return ResponseEntity.ok(train);
	}

	@GetMapping("/number/{number}")
	public ResponseEntity<Train> getTrainByNumber(@PathVariable Integer number) {
		Train train = trainService.getTrainByNumber(number);
		return ResponseEntity.ok(train);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Train>> searchTrainsByName(@PathVariable String name) {
		List<Train> trains = trainService.searchTrainsByName(name);
		return ResponseEntity.ok(trains);
	}

	@GetMapping("/seats-available/{seatsAvailable}")
	public ResponseEntity<List<Train>> searchTrainsBySeatsAvailable(@PathVariable Integer seatsAvailable) {
		List<Train> trains = trainService.searchTrainsBySeatsAvailable(seatsAvailable);
		return ResponseEntity.ok(trains);
	}

	@GetMapping
	public ResponseEntity<List<Train>> getAllTrains() {
		List<Train> trains = trainService.getAllTrains();
		return ResponseEntity.ok(trains);
	}
}
