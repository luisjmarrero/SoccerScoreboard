package tecnicas.software.model;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
public class Play {
    private PlayType type;
    private Player player;
    private int minute;
    private String commentary;

    public Play() {}

    public Play(PlayType type, Player player, int minute, String commentary) {
        this.type = type;
        this.player = player;
        this.minute = minute;
        this.commentary = commentary;
    }

    public PlayType getType() {
        return type;
    }

    public void setType(PlayType type) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
