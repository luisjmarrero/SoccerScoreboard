package tecnicas.software.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer game_id;
    private String stadio;
    private Integer score_a;
    private Integer score_b;
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Team teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistic_id")
    private Statistic statistic;

    public Game() {
    }

    public Game(String stadio, Integer score_a, Integer score_b, Team teamA, Team teamB, Date startDate, Date endDate, Statistic statistic) {
        this.stadio = stadio;
        this.score_a = score_a;
        this.score_b = score_b;
        this.teamA = teamA;
        this.teamB = teamB;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statistic = statistic;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getStadio() {
        return stadio;
    }

    public void setStadio(String stadio) {
        this.stadio = stadio;
    }

    public Integer getScore_a() {
        return score_a;
    }

    public void setScore_a(Integer score_a) {
        this.score_a = score_a;
    }

    public Integer getScore_b() {
        return score_b;
    }

    public void setScore_b(Integer score_b) {
        this.score_b = score_b;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }
}