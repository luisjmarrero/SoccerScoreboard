package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Player;
import tecnicas.software.service.PlayerService;

import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@RestController
@RequestMapping(value = {"/players"})
public class PlayerRestController {

    PlayerService playerService;

    @Autowired
    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Player> getAll(){
        return playerService.getAll();
    }

    @RequestMapping(value = "/all/ordered/team", method = RequestMethod.GET)
    public List<Player> getAllOrdered(){
        return playerService.getAllOrderedByTeam();
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public List<Player> getByTeam(@PathVariable Integer id){
        return playerService.getByTeam(id);
    }

    @RequestMapping(value = "/number/{number}", method = RequestMethod.GET)
    public List<Player> getByNumber(@PathVariable int number){
        return playerService.getByNumber(number);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Player> create(@RequestBody Player player){
        return playerService.create(player);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Player updateByNumber(@PathVariable Integer id, @RequestBody Player player) {
        return playerService.updateByNumber(id, player);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Player> remove(@RequestParam(value="id", required = true) @PathVariable Integer id){
        return playerService.remove(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Players endpoint";
    }
}
