package com.topcoder.bullettrain.controller;

import com.topcoder.bullettrain.model.Train;
import com.topcoder.bullettrain.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/trains")
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //1) search train that have same value
    @GetMapping("/sharing-tracks")
    public ResponseEntity<List<Train>> sameSharingTracks(){
        List<Train> Trains = trainRepository.findBySharingtracks(true);
        return new ResponseEntity<>(Trains, HttpStatus.OK);
    }

    //2) Search trains which amenities values contains keyword
    @GetMapping
    public ResponseEntity<Object> sameSharingTracks(@RequestParam(value="amenities") String keywords){
        Map<String, Object> response = new HashMap<>();
        List<Train> trains = new ArrayList<>();
        if(!keywords.equals("")){
            trainRepository.findByAmenitiesContainingIgnoreCase(keywords).forEach(trains::add);
            if(trains.isEmpty()){
                response.put("message", "train not found");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(trains, HttpStatus.OK);
    }

    //3) Create new endpoint to delete a train
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrain(@PathVariable("id") Long id){
        Optional<Train> train = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if(train.isPresent()){
            trainRepository.deleteById(id);
            response.put("message", "train removed successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            response.put("message", "train not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
