package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Player;
import tecnicas.software.repository.PlayerRepository;

import java.util.List;

/**
 * Created by luisjosemarrero on 4/6/17.
 */
@Service
public class PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    public List<Player> getAllOrderedByTeam(){
        return playerRepository.findAllOrderTeam();
    }

    public List<Player> getByTeam(Integer id){
        return playerRepository.findByTeam(id);
    }

    public List<Player> getByNumber(int number){
        return playerRepository.findByNumber(number);
    }

    public List<Player> create(Player player){
        playerRepository.save(player);
        return playerRepository.findAll();
    }

    public List<Player> updateByNumber(Player player) {
        Player update = playerRepository.findOne(player.getPlayer_id());
        update.setName(player.getName());
        update.setLastName(player.getLastName());
        update.setPosition(player.getPosition());
        update.setNumber(player.getNumber());
        update.setTeam(player.getTeam());
        Player p = playerRepository.save(update);
        System.out.println(p.toString());
        return getAllOrderedByTeam();
    }

    public List<Player> remove(Integer id){
        playerRepository.delete(id);
        return playerRepository.findAll();
    }
}
