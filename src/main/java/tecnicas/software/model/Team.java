package tecnicas.software.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer team_id;
    private String name;
//    private List<Player> players;

    public Team() {
        super();
    }

    public Team(String name) {
        this.name = name;
    }

    //    public Team(String name, List<Player> players) {
//        this.name = name;
//        this.players = players;
//    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
//    public List<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }
}
