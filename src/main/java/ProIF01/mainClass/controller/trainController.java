package ProIF01.mainClass.controller;

import ProIF01.mainClass.model.train;
import ProIF01.mainClass.repository.trainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api") //ketika akses semua endpoint harus diawali "/api"
public class trainController {
    @Autowired
    trainRepository trainRepository;

    //endpoint to view all train
    @GetMapping("/trains")
    public ResponseEntity viewAllTrain(){
        try{
            List<train> trains = new ArrayList<>();
            trainRepository.findAll().forEach(trains::add); //no query needed krn pakai JPA

            //untuk responsenya
            Map<String, Object> response = new HashMap<>();
            if(trains.isEmpty()){
                //response no content ini ceknya di postman biar jelas ("204 No Content")
                response.put("error", "train not found");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }else{
                //TODO: ubah ke JSON nya gmn
                return new ResponseEntity<>(trains, HttpStatus.OK);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Internal server error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //endpoint to view train detail by id
    @GetMapping("/trains/{id}")
    public ResponseEntity viewTrainDetail(@PathVariable("id") Long id){
        Optional<train> trainDetail = trainRepository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if(trainDetail.isPresent()){
            return new ResponseEntity<>(trainDetail.get(), HttpStatus.OK);
        }else{
            response.put("message", "train not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
