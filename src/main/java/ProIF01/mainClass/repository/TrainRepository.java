package ProIF01.mainClass.repository;

import ProIF01.mainClass.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    public List<Train> viewAllTrain();
    public Train viewTrainDetail(Long id);
}
