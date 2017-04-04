package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Player;

import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    List<Player> findByTeam(String team);
}
