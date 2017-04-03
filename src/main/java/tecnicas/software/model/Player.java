package tecnicas.software.model;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
public class Player {
    private String name;
    private String lastName;
    private String position;
    private Team team;

    public Player() {}

    public Player(String name, String lastName, String position, Team team) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.team = team;
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
}
