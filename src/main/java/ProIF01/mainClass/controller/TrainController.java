package ProIF01.mainClass.controller;

import ProIF01.mainClass.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrainController {
    @Autowired
    TrainRepository trainRepository;

    //TODO : bikin end point & actiong untuk kedua task :)
}
