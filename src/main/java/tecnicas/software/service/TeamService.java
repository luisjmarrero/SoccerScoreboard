package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Team;
import tecnicas.software.repository.TeamRepository;

import java.util.List;

/**
 * Created by luisjosemarrero on 4/6/17.
 */
@Service
public class TeamService {

    TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    // FIXME - Explota (HTTP Status = 500)
    public List<Team> getByName(String team){
        return teamRepository.findByNameLike(team);
    }

    public List<Team> create(Team team){
        teamRepository.save(team);
        return teamRepository.findAll();
    }

    public Team updateByNumber(Integer id, Team team) {
        Team update = teamRepository.findOne(id);
        update.setName(team.getName());
        return teamRepository.save(update);
    }

    public List<Team> remove(Integer id){
        teamRepository.delete(id);
        return teamRepository.findAll();
    }

    public Team getByID(Integer id) {
        return teamRepository.findOne(id);
    }
}
