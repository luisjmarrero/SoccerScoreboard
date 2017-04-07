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

    // FIXME - Explota (HTTP Status = 500)
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Team> getByName(@PathVariable String team){
        return teamService.getByName(team);
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public List<Team> create(@RequestBody Team team){
        return teamService.create(team);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public Team updateByNumber(@PathVariable Integer id, @RequestBody Team team) {
        return teamService.updateByNumber(id, team);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Team> remove(@RequestParam(value="id", required = true) @PathVariable Integer id){
        return teamService.remove(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "It works! - Teams endpoint";
    }
}
