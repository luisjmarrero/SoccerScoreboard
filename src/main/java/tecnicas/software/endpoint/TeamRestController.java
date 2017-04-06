package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Team;
import tecnicas.software.repository.TeamRepository;

import java.util.List;

/**
 * Created by Luis Marrero on 4/4/2017.
 */
@RestController
@RequestMapping(value = {"/teams"})
public class TeamRestController {

    TeamRepository teamRepository;

    @Autowired
    public TeamRestController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    // FIXME - Explota (HTTP Status = 500)
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Team> getByName(@PathVariable String team){
        return teamRepository.findByNameLike(team);
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public List<Team> create(@RequestBody Team team){
        teamRepository.save(team);
        return teamRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Team updateByNumber(@PathVariable Integer id, @RequestBody Team team) {
        Team update = teamRepository.findOne(id);
        update.setName(team.getName());
        return teamRepository.save(update);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Team> remove(@RequestParam(value="id", required = true) @PathVariable Integer id){
        teamRepository.delete(id);
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Teams endpoint";
    }
}
