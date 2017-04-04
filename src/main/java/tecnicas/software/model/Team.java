package tecnicas.software.model;

import javax.persistence.*;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long team_id;
    private String name;

    public Team() {}

    public Team(String name) {
        this.name = name;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
