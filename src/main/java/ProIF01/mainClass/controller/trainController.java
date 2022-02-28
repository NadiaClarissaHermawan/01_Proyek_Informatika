package ProIF01.mainClass.controller;

import ProIF01.mainClass.model.train;
import ProIF01.mainClass.repository.trainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api") //ketika akses semua endpoint harus diawali "/api"
public class trainController {
    @Autowired
    trainRepository trainRepository;

    //endpoint to view all train
    @GetMapping("/trains")
    public ResponseEntity<List<train>> viewAllTrain(){
        try{
            List<train> trains = new ArrayList<>();
            trainRepository.findAll().forEach(trains::add); //no query needed krn pakai JPA

            if(trains.isEmpty()){
                //response no content ini ceknya di postman biar jelas ("204 No Content")
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(trains, HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //endpoint to view train detail by id
    @GetMapping("/trains/{id}")
    public ResponseEntity<train> viewTrainDetail(@PathVariable("id") Long id){
        Optional<train> trainDetail = trainRepository.findById(id);
        if(trainDetail.isPresent()){
            return new ResponseEntity<>(trainDetail.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
