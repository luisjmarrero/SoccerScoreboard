package tecnicas.software.model;

import javax.persistence.*;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name="play_types")
public class PlayType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer play_type_id;
    String type;
    String message;

    public PlayType() {
    }

    public PlayType(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Integer getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(Integer play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
