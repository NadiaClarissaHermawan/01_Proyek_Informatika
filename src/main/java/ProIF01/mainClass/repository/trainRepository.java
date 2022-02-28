package ProIF01.mainClass.repository;

import ProIF01.mainClass.model.train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface trainRepository extends JpaRepository<train, Long> {
    public List<train> viewAllTrain();
    public train viewTrainDetail(Long id);
}
