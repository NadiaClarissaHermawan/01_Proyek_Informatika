package com.topcoder.bullettrain.repository;

import com.topcoder.bullettrain.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByAmenitiesContainingIgnoreCase(String keyword);
    List<Train> findBySharingtracks(boolean id);
}