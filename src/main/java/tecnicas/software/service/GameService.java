package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Game;
import tecnicas.software.model.Statistic;
import tecnicas.software.repository.GameRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    public List<Game> getOrdered(){
        return gameRepository.findAllOrOrderByDateDesc();
    }

    public Game getByID(Integer id){
        return gameRepository.findOne(id);
    }

    public List<Game> create(Game game){
        game.setScore_a(0);
        game.setScore_b(0);
        Statistic statistic = new Statistic();
        statistic.setFouls_away(new Integer(0));
        statistic.setFouls_local(new Integer(0));
        statistic.setYellow_away(new Integer(0));
        statistic.setYellow_local(new Integer(0));
        statistic.setRed_away(new Integer(0));
        statistic.setRed_local(new Integer(0));
        statistic.setCorner_away(new Integer(0));
        statistic.setCorner_local(new Integer(0));
        statistic.setOffside_away(new Integer(0));
        statistic.setOffside_local(new Integer(0));
        game.setStatistic(statistic);
        game.setDate(new Date());
        gameRepository.save(game);
        return getAll();
    }

    public void updateGame(Game game){
        gameRepository.save(game);
    }

    public List<Game> delete(Integer id) {
        gameRepository.delete(id);
        return gameRepository.findAll();
    }

    public Game getLast() {
        Game game = gameRepository.findLastGame();
//        game.setDate(game.getDate());
        System.err.println(game.getDate());
        return game;
    }
}
