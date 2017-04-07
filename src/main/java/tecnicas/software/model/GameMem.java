package tecnicas.software.model;

import java.util.List;

/**
 * Created by luisjosemarrero on 4/6/17.
 */
public class GameMem {
    private Game game;
    private int scoreA;
    private int scoreB;
    private int minute;
    private int extra;
    List<Play> playList;

    public GameMem(Game game, int scoreA, int scoreB, int minute, int extra, List<Play> playList) {
        this.game = game;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.minute = minute;
        this.extra = extra;
        this.playList = playList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }
}
