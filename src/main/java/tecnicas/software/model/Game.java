package tecnicas.software.model;

import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
public class Game {
    private String stadio;
    private Team teamA;
    private Team teamB;
    private int goalsA;
    private int goalsB;
    private List<Player> linupA;
    private List<Player> linupB;

    public Game() {}

    public Game(String stadio, Team teamA, Team teamB, int goalsA, int goalsB, List<Player> linupA, List<Player> linupB) {
        this.stadio = stadio;
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
        this.linupA = linupA;
        this.linupB = linupB;
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

    public int getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(int goalsA) {
        this.goalsA = goalsA;
    }

    public int getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(int goalsB) {
        this.goalsB = goalsB;
    }

    public List<Player> getLinupA() {
        return linupA;
    }

    public void setLinupA(List<Player> linupA) {
        this.linupA = linupA;
    }

    public List<Player> getLinupB() {
        return linupB;
    }

    public void setLinupB(List<Player> linupB) {
        this.linupB = linupB;
    }
}
