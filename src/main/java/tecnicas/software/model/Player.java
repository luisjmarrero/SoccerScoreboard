package tecnicas.software.model;

import javax.persistence.*;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer player_id;
    private String name;
    private String lastName;
    private String position;
    private int number;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
        super();
    }

    public Player(String name, String lastName, String position,int number, Team team) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.team = team;
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
