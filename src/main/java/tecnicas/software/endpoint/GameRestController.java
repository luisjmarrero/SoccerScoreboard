package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Game;
import tecnicas.software.service.GameService;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@RestController
@RequestMapping(value = {"/games"})
public class GameRestController {

    GameService gameService;

    @Autowired
    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/all")
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @RequestMapping(value = "/{id}")
    public Game getById(@PathVariable Integer id) {
        return gameService.getByID(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Game> create(@RequestBody Game game) {
        return gameService.create(game);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Game> delete(@PathVariable Integer id) {
        return gameService.delete(id);
    }
}
