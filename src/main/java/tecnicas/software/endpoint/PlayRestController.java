package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Play;
import tecnicas.software.model.PlayType;
import tecnicas.software.repository.PlayRepository;
import tecnicas.software.repository.PlayerRepository;

import java.util.List;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@RestController
@RequestMapping(value = {"/play"})
public class PlayRestController {

    PlayRepository playRepository;

    @Autowired
    public PlayRestController(PlayRepository playRepository,PlayerRepository playerRepository) {
        this.playRepository = playRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Play> getAll(){
        return playRepository.findAll();
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public List<Play> getByType(@PathVariable String type){
        return playRepository.findByType(type);
    }

    @RequestMapping(value = "/create")
    public List<Play> create(@RequestBody Play player){
        playRepository.save(player);
        return playRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Play updateByNumber(@PathVariable Integer id, @RequestBody Play player) {
        Play update = playRepository.findOne(id);

        return playRepository.save(update);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Play> remove(@RequestParam(value="id", required = true) @PathVariable Integer id){
        playRepository.delete(id);
        return playRepository.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Play endpoint";
    }
}
