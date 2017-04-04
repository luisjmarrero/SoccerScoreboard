package tecnicas.software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.dao.PlayerRepository;
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

//    @RequestMapping(value = "/team")
//    public List<Player> getByTeam(@RequestParam(value="name", required = true) String team){
//        return playerRepository.findByTeam(team);
//    }

    @RequestMapping(value = "/create")
    public List<Player> create(@RequestBody Player player){
        playerRepository.save(player);
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
    public List<Player> remove(@RequestParam(value="id", required = true) @PathVariable long id){
        playerRepository.delete(id);
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello word!";
    }
}
