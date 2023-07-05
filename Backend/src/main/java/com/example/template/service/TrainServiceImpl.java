package com.example.template.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.template.dto.TrainDTO;
import com.example.template.entity.Train;
import com.example.template.exception.ResourceNotFoundException;
import com.example.template.repo.TrainDAO;

@Service
public class TrainServiceImpl implements TrainService {
	private final TrainDAO trainDAO;

	public TrainServiceImpl(TrainDAO trainDAO) {
		this.trainDAO = trainDAO;
	}

	@Override
	public Train createTrain(TrainDTO trainDTO) {
		Train train = new Train();
		BeanUtils.copyProperties(trainDTO, train);
		return trainDAO.save(train);
	}

	@Override
	public Train updateTrain(Long id, TrainDTO trainDTO) {
		Train train = trainDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train not found with id: "+ id));
		trainDTO.setId(id);
		BeanUtils.copyProperties(trainDTO, train);
		return trainDAO.save(train);
	}

	@Override
	public boolean deleteTrain(Long id) {
		Train train =  trainDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train not found with id: "+ id));
		trainDAO.delete(train);
		return true;
	}

	@Override
	public Train getTrainById(Long id) {
		return trainDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Train not found with id: "+ id));
	}

	@Override
	public Train getTrainByNumber(Integer number) {
		Train train =  trainDAO.findByNumber(number);
		if(train == null){
			throw new ResourceNotFoundException("Train not found with number "+ number);
		}
		return train;
	}

	@Override
	public List<Train> searchTrainsByName(String name) {
		List<Train> trainList =  trainDAO.findByNameContainingIgnoreCase(name);
		if(trainList.isEmpty()){
			throw new ResourceNotFoundException("Train not found with name "+ name);
		}
		return  trainList;
	}

	@Override
	public List<Train> searchTrainsBySeatsAvailable(int seatsAvailable) {
		return trainDAO.findBySeatsAvailableGreaterThanEqual(seatsAvailable);
	}

	@Override
	public List<Train> getAllTrains() {
		return trainDAO.findAll();
	}

}
