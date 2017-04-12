package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Team;
import tecnicas.software.repository.TeamRepository;
import tecnicas.software.service.TeamService;

import java.util.List;

/**
 * Created by Luis Marrero on 4/4/2017.
 */
@RestController
@RequestMapping(value = {"/teams"})
public class TeamRestController {

    TeamService teamService;

    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Team> getAll(){
        return teamService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team getById(@PathVariable Integer id){
        return teamService.getByID(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Team> create(@RequestBody Team team) {
        return teamService.create(team);
    }

    @RequestMapping(value = "/update", method=RequestMethod.PUT)
    public Team update(@RequestBody Team team) {
        return teamService.update(team);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Team> remove(@PathVariable Integer id){
        return teamService.remove(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Teams endpoint";
    }
}
