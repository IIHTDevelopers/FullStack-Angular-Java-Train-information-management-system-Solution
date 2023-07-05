package com.example.template.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.template.entity.Train;

public interface TrainDAO extends JpaRepository<Train, Long> {
	Train findByNumber(int number);

	List<Train> findByNameContainingIgnoreCase(String name);

	List<Train> findBySeatsAvailableGreaterThanEqual(int seatsAvailable);
}
