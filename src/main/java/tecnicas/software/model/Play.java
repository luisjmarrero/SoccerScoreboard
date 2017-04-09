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
    @Enumerated(EnumType.STRING)
    private PlayType type;
    private Integer minute;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    private Date date;
    private String commentary;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Play() {}

    public Play(PlayType type, Integer minute, Player player, Date date, String commentary, Game game) {
        this.type = type;
        this.minute = minute;
        this.player = player;
        this.date = date;
        this.commentary = commentary;
        this.game = game;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
