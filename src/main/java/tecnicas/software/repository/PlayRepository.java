package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Play;
import tecnicas.software.model.PlayType;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Repository
public interface PlayRepository extends JpaRepository<Play, Integer> {

    @Query(value = "select * from plays WHERE type = ?1", nativeQuery = true)
    List<Play> findByType(String s);

    @Query(value = "select * from plays WHERE game_id = ?1 ORDER BY minute DESC ", nativeQuery = true)
    List<Play> findByGameOrderByDateDesc(Integer id);



}
