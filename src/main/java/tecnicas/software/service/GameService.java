package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Game;
import tecnicas.software.model.GameMem;
import tecnicas.software.model.Play;
import tecnicas.software.repository.GameRepository;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Service
public class GameService {
    private GameRepository gameRepository;
    private PlayService playService;

    @Autowired
    public GameService(GameRepository gameRepository, PlayService playService) {
        this.gameRepository = gameRepository;
        this.playService = playService;
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

    public GameMem updateGameOnMemory(GameMem gameMem){
        boolean upt = false;
        if (gameMem.getMinute() == 90){
            if (gameMem.getExtra() < gameMem.getGame().getExtra()){
                int extra = gameMem.getExtra() + 1;
                gameMem.setExtra(extra);
                gameMem.setPlayList(playService.getCurrent(gameMem.getGame().getGame_id(), gameMem.getMinute()));
            }
        } else {
            int minute = gameMem.getMinute() + 1;
            gameMem.setMinute(minute);
            gameMem.setPlayList(playService.getCurrent(gameMem.getGame().getGame_id(), gameMem.getMinute()));
        }

        return gameMem;
    }

}
