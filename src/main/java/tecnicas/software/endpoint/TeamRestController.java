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

    @GetMapping(value = "/all")
    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/{name}")
    public List<Team> getByName(@RequestParam(value="name", required = true) String team){
        return teamRepository.findByName(team);
    }

    @RequestMapping(value = "/create")
    public List<Team> create(@RequestBody Team team){
        teamRepository.save(team);
        return teamRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Team updateByNumber(@PathVariable long id, @RequestBody Team team) {
        Team update = teamRepository.findOne(id);
        update.setName(team.getName());
        return teamRepository.save(update);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Team> remove(@RequestParam(value="id", required = true) @PathVariable long id){
        teamRepository.delete(id);
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Teams endpoint";
    }
}
