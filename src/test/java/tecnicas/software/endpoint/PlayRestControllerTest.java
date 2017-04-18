package tecnicas.software.endpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tecnicas.software.model.Play;
import tecnicas.software.repository.PlayRepository;
import tecnicas.software.service.PlayService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alfonsohdez08 on 4/17/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayRestControllerTest {

    List<Play> playList;
    @Autowired
    PlayService playService;
    @Autowired
    PlayRepository playRepository;

    @Test
    public void getAll() throws Exception {
        playList = playService.getAll();
        final int EMPTY_SIZE = 0;

        assertNotEquals(EMPTY_SIZE, playList.size());
    }

    @Test
    public void getAllDate() throws Exception {
    }

    @Test
    public void getByType() throws Exception {
    }

    @Test
    public void geTypes() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void updateById() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

}