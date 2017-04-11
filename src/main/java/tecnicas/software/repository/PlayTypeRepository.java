package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.PlayType;

import java.util.List;

/**
 * Created by Luis Marrero on 10/4/2017.
 */
@Repository
public interface PlayTypeRepository extends JpaRepository<PlayType, Integer>{

    @Query(value = "SELECT * FROM play_types;", nativeQuery = true)
    List<PlayType> findTypes();
}
