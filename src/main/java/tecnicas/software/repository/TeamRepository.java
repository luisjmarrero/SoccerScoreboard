package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Team;

import java.util.List;

/**
 * Created by Luis Marrero on 4/4/2017.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

    List<Team> findByName(String name);
}
