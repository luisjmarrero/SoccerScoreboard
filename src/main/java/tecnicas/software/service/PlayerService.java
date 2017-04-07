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

    public Player updateByNumber(Integer id, Player player) {
        Player update = playerRepository.findOne(id);
        update.setName(player.getName());
        update.setLastName(player.getLastName());
        update.setPosition(player.getPosition());
        update.setNumber(player.getNumber());
        update.setOnField(player.isOnField());
        update.setTeam(player.getTeam());
        return playerRepository.save(update);
    }

    public List<Player> remove(Integer id){
        playerRepository.delete(id);
        return playerRepository.findAll();
    }
}
