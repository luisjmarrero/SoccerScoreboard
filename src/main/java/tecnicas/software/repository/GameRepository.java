package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Game;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    @Query(value ="SELECT * FROM games ORDER BY game_id DESC LIMIT 1",  nativeQuery = true)
    Game findLastGame();
}
