package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Statistic;

/**
 * Created by Luis Marrero on 11/4/2017.
 */
@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer>{
}
