package com.example.template.service;

import java.util.List;

import com.example.template.dto.TrainDTO;
import com.example.template.entity.Train;

public interface TrainService {
	Train createTrain(TrainDTO trainDTO);

	Train updateTrain(Long id, TrainDTO trainDTO);

	boolean deleteTrain(Long id);

	Train getTrainById(Long id);

	Train getTrainByNumber(Integer number);

	List<Train> searchTrainsByName(String name);

	List<Train> searchTrainsBySeatsAvailable(int seatsAvailable);

	List<Train> getAllTrains();
}
