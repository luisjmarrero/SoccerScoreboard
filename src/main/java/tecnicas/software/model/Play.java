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
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    private String commentary;
    private Boolean local;

    public Play() {}

    public Play(PlayType type, Integer minute, Player player, Game game, String commentary, Boolean local) {
        this.type = type;
        this.minute = minute;
        this.player = player;
        this.game = game;
        this.commentary = commentary;
        this.local = local;
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
        return player;
    }

    public void setPlayer_a(Player player) {
        this.player = player;
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

    public Boolean getLocal() {
        return local;
    }

    public void setLocal(Boolean local) {
        this.local = local;
    }
}
