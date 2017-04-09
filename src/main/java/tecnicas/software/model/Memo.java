package tecnicas.software.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Luis Marrero on 9/4/2017.
 *
 *      TU REAL FORCE
 */
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer memo_id;
    private Integer id;

    public Memo() {
    }

    public Memo(Integer id) {
        this.id = id;
    }

    public Integer getMemo_id() {
        return memo_id;
    }

    public void setMemo_id(Integer memo_id) {
        this.memo_id = memo_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
