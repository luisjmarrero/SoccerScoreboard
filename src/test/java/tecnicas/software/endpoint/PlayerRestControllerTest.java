package tecnicas.software.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tecnicas.software.model.Player;
import tecnicas.software.model.Team;
import tecnicas.software.repository.PlayerRepository;
import tecnicas.software.service.PlayerService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alfonsohdez08 on 4/15/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRestControllerTest {

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerRepository playerRepository;

    List<Player> players;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        players = playerService.getAll();

        assertNotEquals(0, players.size());
    }

    @Test
    //TODO: Implementar Sort para que ordene por team_id
    public void getAllOrdered() throws Exception{
        //List<Player> playersOrderedByService = playerService.getAllOrderedByTeam();

    }

    @Test
    public void getByTeam() throws Exception{
        players = playerService.getByTeam(68);

        for(Player player : players){
            assertEquals(new Integer(68), player.getTeam().getTeam_id());
        }
    }

    @Test
    //TODO:
    public void getByNumber() throws Exception{
        //Player player = playerService.getByNumber(70);
    }

    @Test
    //FIXME: Arreglar el newTeam()
    public void create() throws Exception{
        Player player = new Player("Samuel", "Eto'o", "Delantero", 48, new Team("FC Barcelona"));

        playerService.create(player);

        for(Player tempPlayer : playerRepository.findAll()){
            if(tempPlayer.equals(player)){
                System.out.println("Jugador creado exitosamente!");
                playerRepository.delete(player);
            }
        }
    }

    @Test
    public void updateByNumber() throws Exception{

    }





}