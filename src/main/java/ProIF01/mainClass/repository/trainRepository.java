package ProIF01.mainClass.repository;

import ProIF01.mainClass.model.train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface trainRepository extends JpaRepository<train, Long> {

//    public List<train> viewAllTrain();
//    public train viewTrainDetail(Long id);

}
