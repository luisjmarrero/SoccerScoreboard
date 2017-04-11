package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Play;
import tecnicas.software.model.PlayType;
import tecnicas.software.repository.PlayerRepository;
import tecnicas.software.service.PlayService;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@RestController
@RequestMapping(value = {"/plays"})
public class PlayRestController {

    PlayService playService;

    @Autowired
    public PlayRestController(PlayService playService,PlayerRepository playerRepository) {
        this.playService = playService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Play> getAll(){
        return playService.getAll();
    }

    @RequestMapping(value = "/all/ordered/game/{id}", method = RequestMethod.GET)
    public List<Play> getAllDate(@PathVariable Integer id){
        return playService.getAllOrderedByDate(id);
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public List<Play> getByType(@PathVariable String type){
        return playService.getByType(type);
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<PlayType> geTypes(){
        return playService.geTypes();
    }

    @RequestMapping(value = "/create")
    public List<Play> create(@RequestBody Play player){
        return playService.create(player);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Play updateById(@PathVariable Integer id, @RequestBody Play player) {
        return playService.updateById(id, player);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Play> remove(@PathVariable Integer id){
        return playService.remove(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Play endpoint";
    }
}
