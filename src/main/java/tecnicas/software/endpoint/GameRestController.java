package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tecnicas.software.model.Game;
import tecnicas.software.service.GameService;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@RestController
@RequestMapping(value = {"/game"})
public class GameRestController {

    GameService gameService;

    @Autowired
    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/all")
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Game> create(@RequestBody Game game){
        return gameService.create(game);
    }
}
