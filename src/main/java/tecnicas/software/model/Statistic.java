package tecnicas.software.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Luis Marrero on 9/4/2017.
 */
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer statistic_id;
    private Integer posesion_local;
    private Integer fouls_local;
    private Integer yellow_local;
    private Integer red_local;
    private Integer corner_local;
    private Integer offside_local;
    private Integer posesion_away;
    private Integer fouls_away;
    private Integer yellow_away;
    private Integer red_away;
    private Integer corner_away;
    private Integer offside_away;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;

    public Statistic() {
    }

    public Statistic(Integer posesion_local, Integer fouls_local, Integer yellow_local, Integer red_local, Integer corner_local, Integer offside_local, Integer posesion_away, Integer fouls_away, Integer yellow_away, Integer red_away, Integer corner_away, Integer offside_away, Game game) {
        this.posesion_local = posesion_local;
        this.fouls_local = fouls_local;
        this.yellow_local = yellow_local;
        this.red_local = red_local;
        this.corner_local = corner_local;
        this.offside_local = offside_local;
        this.posesion_away = posesion_away;
        this.fouls_away = fouls_away;
        this.yellow_away = yellow_away;
        this.red_away = red_away;
        this.corner_away = corner_away;
        this.offside_away = offside_away;
        this.game = game;
    }

    public Integer getStatistic_id() {
        return statistic_id;
    }

    public void setStatistic_id(Integer statistic_id) {
        this.statistic_id = statistic_id;
    }

    public Integer getPosesion_local() {
        return posesion_local;
    }

    public void setPosesion_local(Integer posesion_local) {
        this.posesion_local = posesion_local;
    }

    public Integer getFouls_local() {
        return fouls_local;
    }

    public void setFouls_local(Integer fouls_local) {
        this.fouls_local = fouls_local;
    }

    public Integer getYellow_local() {
        return yellow_local;
    }

    public void setYellow_local(Integer yellow_local) {
        this.yellow_local = yellow_local;
    }

    public Integer getRed_local() {
        return red_local;
    }

    public void setRed_local(Integer red_local) {
        this.red_local = red_local;
    }

    public Integer getCorner_local() {
        return corner_local;
    }

    public void setCorner_local(Integer corner_local) {
        this.corner_local = corner_local;
    }

    public Integer getOffside_local() {
        return offside_local;
    }

    public void setOffside_local(Integer offside_local) {
        this.offside_local = offside_local;
    }

    public Integer getPosesion_away() {
        return posesion_away;
    }

    public void setPosesion_away(Integer posesion_away) {
        this.posesion_away = posesion_away;
    }

    public Integer getFouls_away() {
        return fouls_away;
    }

    public void setFouls_away(Integer fouls_away) {
        this.fouls_away = fouls_away;
    }

    public Integer getYellow_away() {
        return yellow_away;
    }

    public void setYellow_away(Integer yellow_away) {
        this.yellow_away = yellow_away;
    }

    public Integer getRed_away() {
        return red_away;
    }

    public void setRed_away(Integer red_away) {
        this.red_away = red_away;
    }

    public Integer getCorner_away() {
        return corner_away;
    }

    public void setCorner_away(Integer corner_away) {
        this.corner_away = corner_away;
    }

    public Integer getOffside_away() {
        return offside_away;
    }

    public void setOffside_away(Integer offside_away) {
        this.offside_away = offside_away;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
