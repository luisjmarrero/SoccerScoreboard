package tecnicas.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tecnicas.software.model.Memo;

/**
 * Created by Luis Marrero on 9/4/2017.
 */
@Repository
public interface MemoRepository extends JpaRepository<Memo, Integer>{

    @Query(value ="SELECT * FROM memo ORDER BY memo_id DESC LIMIT 1",  nativeQuery = true)
    Memo getLast();
}
