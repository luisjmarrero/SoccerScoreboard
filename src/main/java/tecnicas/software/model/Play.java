package tecnicas.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name="plays")
public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer play_id;
    @ManyToOne
    @JoinColumn(name = "play_type_id")
    private PlayType type;
    private Integer minute;
    @ManyToOne
    @JoinColumn(name = "player_id_a")
    private Player player_a;
    @ManyToOne
    @JoinColumn(name = "player_id_b")
    private Player player_b;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    String commentary;

    public Play() {}

    public Play(PlayType type, Integer minute, Player player_a, Player player_b, Game game, String commentary) {
        this.type = type;
        this.minute = minute;
        this.player_a = player_a;
        this.player_b = player_b;
        this.game = game;
        this.commentary = commentary;
    }

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public PlayType getType() {
        return type;
    }

    public void setType(PlayType type) {
        this.type = type;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Player getPlayer_a() {
        return player_a;
    }

    public void setPlayer_a(Player player_a) {
        this.player_a = player_a;
    }

    public Player getPlayer_b() {
        return player_b;
    }

    public void setPlayer_b(Player player_b) {
        this.player_b = player_b;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
