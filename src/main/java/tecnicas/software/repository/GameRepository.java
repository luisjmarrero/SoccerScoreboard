package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Game;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
