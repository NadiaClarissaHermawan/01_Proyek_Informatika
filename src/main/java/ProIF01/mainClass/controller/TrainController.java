package ProIF01.mainClass.controller;

import ProIF01.mainClass.model.Train;
import ProIF01.mainClass.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //endpoint to view all train
    @GetMapping("/trains/")
    public ResponseEntity<List<Train>> viewAllTrain(){
        try{
            List<Train> trains = new ArrayList<>();
            trainRepository.findAll().forEach(trains::add);
            if(trains.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(trains, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //endpoint to view train detail by id
    @GetMapping("/trains/:{id}")
    public ResponseEntity<Train> viewTrainDetail(@PathVariable("id") Long id){
        Optional<Train> trainDetail = trainRepository.findById(id);
        if(trainDetail.isPresent()){
            return new ResponseEntity<>(trainDetail.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
