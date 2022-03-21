package com.topcoder.oldtrain.controller;

import com.topcoder.oldtrain.model.Train;
import com.topcoder.oldtrain.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.*;

@RestController
@RequestMapping("/api/trains") //ketika akses semua endpoint harus diawali "/api"
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //1) Create new endpoint to edit existing train by id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTrain(@PathVariable("id") Long id, @RequestBody Train train){
        Optional<Train> trainData = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();
        boolean datatype = true;

        if(trainData.isPresent()){
            Train updateTrain = trainData.get();

            if(train.getName() != null){
                if (train.getName().getClass().getSimpleName().equalsIgnoreCase("String")) {
                    updateTrain.setName(train.getName());
                }else if (!train.getName().getClass().getSimpleName().equalsIgnoreCase("String")) {
                    datatype = false;
                }
            }

            if(train.getDescription() != null){
                if (train.getDescription().getClass().getSimpleName().equalsIgnoreCase("String"))
                    updateTrain.setDescription(train.getDescription());
                else if (!train.getDescription().getClass().getSimpleName().equalsIgnoreCase("String"))
                    datatype = false;
            }

            if(train.getDistancebetweenstop() != null){
                if (train.getDistancebetweenstop().getClass().getSimpleName().equalsIgnoreCase("String"))
                    updateTrain.setDistancebetweenstop(train.getDistancebetweenstop());
                else if (!train.getDistancebetweenstop().getClass().getSimpleName().equalsIgnoreCase("String"))
                    datatype = false;
            }

            if(train.getMaxspeed() != null){
                if (train.getMaxspeed().getClass().getSimpleName().equalsIgnoreCase("String"))
                    updateTrain.setMaxspeed(train.getMaxspeed());
                else if (!train.getMaxspeed().getClass().getSimpleName().equalsIgnoreCase("String"))
                    datatype = false;
            }

            if(train.getTrainfrequency() != null){
                if (train.getTrainfrequency().getClass().getSimpleName().equalsIgnoreCase("String"))
                    updateTrain.setTrainfrequency(train.getTrainfrequency());
                else if (!train.getTrainfrequency().getClass().getSimpleName().equalsIgnoreCase("String"))
                    datatype = false;
            }

            if(train.getAmenities() != null){
                if (train.getAmenities().getClass().getSimpleName().equalsIgnoreCase("String"))
                    updateTrain.setAmenities(train.getAmenities());
                else if (!train.getAmenities().getClass().getSimpleName().equalsIgnoreCase("String"))
                    datatype = false;
            }

            if(train.getSharingtracks() != null) {
                if (train.getSharingtracks().getClass().getSimpleName().equalsIgnoreCase("boolean"))
                    updateTrain.setSharingtracks(train.getSharingtracks());
                else if (!train.getSharingtracks().getClass().getSimpleName().equalsIgnoreCase("boolean"))
                    datatype = false;
            }

            if(train.getGradecrossing() != null){
                if(train.getGradecrossing().getClass().getSimpleName().equalsIgnoreCase("boolean"))
                    updateTrain.setGradecrossing(train.getGradecrossing());
                else if(!train.getGradecrossing().getClass().getSimpleName().equalsIgnoreCase("boolean"))
                    datatype = false;
            }

            if(datatype == true){
                trainRepository.save(updateTrain);
                response.put("message", "train edited successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.put("message", "failed when edit train");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }else{
            response.put("message", "train not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    //2)  Create new endpoint to create a new train
    @PostMapping
    public ResponseEntity<Object> createNewTrain(@RequestBody Train train){
        Map<String, Object> response = new HashMap<>();
        try {
            boolean indicator = true;
            if(train.getName() == null || train.getDescription() == null || train.getDistancebetweenstop() == null
                || train.getMaxspeed() == null || train.getTrainfrequency() == null || train.getAmenities() == null || train.getGradecrossing() == null)
                indicator = false;

            if(indicator){
                Train newTrain = trainRepository.save(new Train(trainRepository.count()+1, train.getName(), train.getDescription(), train.getDistancebetweenstop(), train.getMaxspeed(), train.getSharingtracks(), train.getGradecrossing(), train.getTrainfrequency(), train.getAmenities()));
                response.put("message", "new train added successfully");
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }else{
                response.put("message", "failed validation");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            response.put("message", "failed validation");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
