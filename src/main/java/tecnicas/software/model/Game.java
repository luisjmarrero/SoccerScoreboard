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
    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "team_a_id")
    @JoinColumn(name = "team_a_id")
    private Team teamA;
    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "team_b_id")
    @JoinColumn(name = "team_b_id")
    private Team teamB;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    private Date endDate;

    public Game() {}

    public Game(String stadio, Team teamA, Team teamB, int goalsA, int goalsB) {
        this.stadio = stadio;
        this.teamA = teamA;
        this.teamB = teamB;

    }

    public String getStadio() {
        return stadio;
    }

    public void setStadio(String stadio) {
        this.stadio = stadio;
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

//    @PrePersist
//    void createdAt() {
//        this.startDate = new Date();
//    }
}
