package com.topcoder.oldtrain.controller;

import com.topcoder.oldtrain.model.Train;
import com.topcoder.oldtrain.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api") //ketika akses semua endpoint harus diawali "/api"
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //endpoint to view all train
    @GetMapping("/trains")
    public ResponseEntity viewAllTrain(){
        List<Train> Trains = new ArrayList<>();
        trainRepository.findAll().forEach(Trains::add); //no query needed krn pakai JPA
        return new ResponseEntity<>(Trains, HttpStatus.OK);
    }

    //endpoint to view train detail by id
    @GetMapping("/trains/{id}")
    public ResponseEntity viewTrainDetail(@PathVariable("id") Long id){
        Optional<Train> trainDetail = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if(trainDetail.isPresent()){
            return new ResponseEntity<>(trainDetail.get(), HttpStatus.OK);
        }else{
            response.put("message", "train not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    // override getErrorPath deprecated
    // https://docs.spring.io/spring-boot/docs/2.3.8.RELEASE/api//org/springframework/boot/we
}
