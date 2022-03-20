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
    @PutMapping("/:{id}")
    public ResponseEntity<Object> updateTrain(@PathVariable("id") Long id, @RequestBody Train train){
        Optional<Train> trainData = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();
        boolean datatype = true;

        if(trainData.isPresent()){
            Train updateTrain = trainData.get();

            if(train.getName() != null) updateTrain.setName(train.getName());
            if(train.getDescription() != null) updateTrain.setDescription(train.getDescription());
            if(train.getDistancebetweenstop() != null) updateTrain.setDistancebetweenstop(train.getDistancebetweenstop());
            if(train.getMaxspeed() != null ) updateTrain.setMaxspeed(train.getMaxspeed());
            if(train.getTrainfrequency() != null) updateTrain.setTrainfrequency(train.getTrainfrequency());
            if(train.getAmenities() != null) updateTrain.setAmenities(train.getAmenities());

            if(train.getSharingtracks() != null && train.getSharingtracks().getClass().getSimpleName().equals("boolean")) updateTrain.setSharingtracks(train.getSharingtracks());
            else if(train.getSharingtracks() != null && !train.getSharingtracks().getClass().getSimpleName().equals("boolean")) datatype = false;
            if(train.getGradecrossing() != null && train.getGradecrossing().getClass().getSimpleName().equals("boolean")) updateTrain.setGradecrossing(train.getGradecrossing());
            else if( train.getSharingtracks() != null && !train.getGradecrossing().getClass().getSimpleName().equals("boolean")) datatype = false;

            if(datatype == true){
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
                || train.getMaxspeed() == null || train.getTrainfrequency() == null || train.getAmenities() == null)
                indicator = false;

            if(indicator){
                Train newTrain = trainRepository.save(new Train(train.getId(), train.getName(), train.getDescription(), train.getDistancebetweenstop(), train.getMaxspeed(), train.getSharingtracks(), train.getGradecrossing(), train.getTrainfrequency(), train.getAmenities()));
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

/*test case 2
 {
    "id": 14,
    "name": "Eurostar e320",
    "description": "kuda tercepat sepanjang masa",
    "amenities": "none",
    "distancebetweenstop": "at least 200 miles",
    "maxspeed": "200 mph",
    "sharingtracks": false,
    "gradecrossing": false,
    "trainfrequency": "12 hours"
}
* */
