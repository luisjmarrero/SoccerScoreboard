package tecnicas.software.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tecnicas.software.model.Game;
import tecnicas.software.repository.GameRepository;
import tecnicas.software.service.GameService;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alfonsohdez08 on 4/17/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRestControllerTest {

    List<Game> games;
    @Autowired
    GameService gameService;
    @Autowired
    GameRepository gameRepository;

    @Test
    public void getAll() throws Exception {
        games = gameService.getAll();
        final int EMPTY_SIZE = 0;

        assertNotEquals(EMPTY_SIZE, games.size());
    }

    @Test
    public void getAllOrdered() throws Exception {
        games = gameService.getOrdered();
        List<Game> gamesSorted = gameRepository.findAll();

        gamesSorted.sort(Comparator.comparing(g -> g.getDate()));

        for(int i = 0; i < gamesSorted.size(); i++){
            assertEquals(gamesSorted.get(i).getGame_id(), games.get(i).getGame_id());

        }
    }

    @Test
    public void getLast() throws Exception {
        Game lastGame = gameService.getLast();
        games = gameRepository.findAll();

        games.sort(Comparator.comparing(g -> g.getDate()));

        if(lastGame.getGame_id().intValue() == games.get(0).getGame_id().intValue()){
            System.out.println("SUCCESFULLY!");
        }
    }

    @Test
    public void getById() throws Exception {
        final int GAME_ID = 15;

        Game gameToFind = gameService.getByID(GAME_ID);

        if(gameToFind != null){
            System.out.println("SUCCESFULLY!");
        }
    }

    @Test
    public void create() throws Exception {
        //Game _newGame = new Game()
    }

    @Test
    public void delete() throws Exception {
        final int GAME_ID_TO_DELETE = 10;

        games = gameService.delete(GAME_ID_TO_DELETE);

        for(Game game : games){
            if(game.getGame_id().intValue() == GAME_ID_TO_DELETE){
                System.out.println("FAILURE!");
            }
        }
    }

}