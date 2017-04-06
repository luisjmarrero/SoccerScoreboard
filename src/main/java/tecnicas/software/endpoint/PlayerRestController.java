package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.repository.PlayerRepository;
import tecnicas.software.model.Player;

import java.util.List;

/**
 * Created by Luis Marrero on 3/4/2017.
 */
@RestController
@RequestMapping(value = {"/players"})
public class PlayerRestController {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerRestController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public List<Player> getByTeam(@PathVariable Integer id){
        return playerRepository.findByTeam(id);
    }

    @RequestMapping(value = "/number/{number}", method = RequestMethod.GET)
    public List<Player> getByTeam(@PathVariable int number){
        return playerRepository.findByNumber(number);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Player> create(@RequestBody Player player){
        playerRepository.save(player);
        return playerRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Player updateByNumber(@PathVariable Integer id, @RequestBody Player player) {
        Player update = playerRepository.findOne(id);
        update.setName(player.getName());
        update.setLastName(player.getLastName());
        update.setPosition(player.getPosition());
        update.setNumber(player.getNumber());
        update.setOnField(player.isOnField());
        update.setTeam(player.getTeam());
        return playerRepository.save(update);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Player> remove(@RequestParam(value="id", required = true) @PathVariable Integer id){
        playerRepository.delete(id);
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Players endpoint";
    }
}
