package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Player;

import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

    @Query(value = "select * from players WHERE players.team_id = ?1", nativeQuery = true)
    List<Player> findByTeam (Integer team);

    @Query(value = "select * from players ORDER by players.team_id", nativeQuery = true)
    List<Player> findAllOrderTeam ();

    List<Player> findByNumber (int number);
}
