package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Game;
import tecnicas.software.repository.GameRepository;

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

    public Game getByID(Integer id){
        return gameRepository.findOne(id);
    }

    public List<Game> create(Game game){
        gameRepository.save(game);
        return getAll();
    }
}
