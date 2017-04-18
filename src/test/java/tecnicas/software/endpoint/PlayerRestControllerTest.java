package tecnicas.software.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tecnicas.software.model.Player;
import tecnicas.software.model.Team;
import tecnicas.software.repository.PlayerRepository;
import tecnicas.software.repository.TeamRepository;
import tecnicas.software.service.PlayerService;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alfonsohdez08 on 4/15/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRestControllerTest {

    List<Player> players;
    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        players = playerService.getAll();
        final int EMPTY_SIZE = 0;

        assertNotEquals(EMPTY_SIZE, players.size());
    }

    @Test
    public void getAllOrdered() throws Exception{
        players = playerService.getAllOrderedByTeam();
        List<Player> playersSorted = playerRepository.findAll();

        playersSorted.sort(Comparator.comparing(p -> p.getTeam().getTeam_id()));

        for(int i = 0; i < players.size(); i++){
            assertEquals(playersSorted.get(i).getTeam().getTeam_id(), players.get(i).getTeam().getTeam_id());
        }

    }

    @Test
    public void getByTeam() throws Exception{
        final int REAL_MADRID_TEAM_ID = 68;
        players = playerService.getByTeam(REAL_MADRID_TEAM_ID);

        for(Player player : players){
            assertEquals(new Integer(REAL_MADRID_TEAM_ID), player.getTeam().getTeam_id());
        }
    }

    @Test
    public void getByNumber() throws Exception{
        final int MESSI_SHIRT_NUMBER = 10;
        players = playerService.getByNumber(MESSI_SHIRT_NUMBER);

        if(players.get(0).getPlayer_id().intValue() == MESSI_SHIRT_NUMBER){
            System.out.println("SUCCESFULLY!");
        }
    }

    @Test
    //FIXME: Problema con el field "on_field"
    public void create() throws Exception{
        final int BARCA_TEAM_ID = 69;
        final int ETO_SHIRT_NUMBER = 48;
        Team team = teamRepository.findOne(BARCA_TEAM_ID);
        Player player = new Player("Samuel", "Eto'o", "Delantero", ETO_SHIRT_NUMBER, team);

        players = playerService.create(player);

        for(Player tempPlayer : players){
            if(tempPlayer.equals(player)){
                System.out.println("SUCCESFULLY!");
                playerRepository.delete(player);
            }
        }
    }

    @Test
    //FIXME: Problema con hacer update!
    public void updateByNumber() throws Exception{
        final int PLAYER_ID_TO_UPDATE = 70;
        Player playerToUpdate = playerRepository.findOne(PLAYER_ID_TO_UPDATE);

        System.out.println("BEFORE: " + playerToUpdate.getPosition());

        playerToUpdate.setPosition("Arquero");

        players = playerService.updateByNumber(playerToUpdate);

        System.out.println("AFTER: " +playerRepository.getOne(PLAYER_ID_TO_UPDATE).getPosition());
    }

    @Test
    public void remove() throws Exception{
        final int PLAYER_ID_TO_REMOVE = 70;
        players = playerService.remove(PLAYER_ID_TO_REMOVE);

        for(Player player : players){
            if(playerRepository.findOne(PLAYER_ID_TO_REMOVE) != null){
                System.out.println("FAILURE!");
            }
        }
    }
}