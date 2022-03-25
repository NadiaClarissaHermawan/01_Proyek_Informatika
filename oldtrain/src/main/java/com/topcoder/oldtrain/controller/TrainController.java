package com.topcoder.oldtrain.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topcoder.oldtrain.model.Train;
import com.topcoder.oldtrain.repository.TrainRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/trains") //ketika akses semua endpoint harus diawali "/api"
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //1) Create new endpoint to edit existing train by id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTrain(@PathVariable("id") Long id, @RequestBody Train train) {
        Optional<Train> trainData = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();
        try {
            if (trainData.isPresent()) {
                Train updateTrain = trainData.get();

                if (train.getName() != null) updateTrain.setName(train.getName());
                if (train.getDescription() != null) updateTrain.setDescription(train.getDescription());
                if (train.getDistancebetweenstop() != null)
                    updateTrain.setDistancebetweenstop(train.getDistancebetweenstop());
                if (train.getMaxspeed() != null) updateTrain.setMaxspeed(train.getMaxspeed());
                if (train.getTrainfrequency() != null) updateTrain.setTrainfrequency(train.getTrainfrequency());
                if (train.getAmenities() != null) updateTrain.setAmenities(train.getAmenities());
                updateTrain.setSharingtracks(train.isSharingtracks());
                updateTrain.setGradecrossing(train.isGradecrossing());
                trainRepository.save(updateTrain);

                response.put("message", "train edited successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "train not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.put("message", "failed when edit train");
            return new ResponseEntity<>(response, BAD_REQUEST);
        }
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleMissingRequestBody(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "failed when edit train");
        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    //2)  Create new endpoint to create a new train
    @PostMapping
    public ResponseEntity<Object> createNewTrain(@RequestBody Train train) {
        Map<String, Object> response = new HashMap<>();
        if(train.getName()==null || train.getDescription() == null || train.getDistancebetweenstop() == null || train.getMaxspeed() == null || train.getTrainfrequency() == null || train.getAmenities() == null){
            response.put("message", "failed validation");
            return new ResponseEntity<>(response, BAD_REQUEST);
        }
        try {
            trainRepository.save(new Train(train.getId(), train.getName(), train.getDescription(), train.getDistancebetweenstop(), train.getMaxspeed(), train.isSharingtracks(), train.isGradecrossing(), train.getTrainfrequency(), train.getAmenities()));
            response.put("message", "new train added successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("message", "failed validation");
            return new ResponseEntity<>(response, BAD_REQUEST);
        }
    }
}
