package tecnicas.software.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
// FIXME !!
@Controller
public class ViewController {

    @RequestMapping(value = {"", "/", "home"})
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        return "view/index";
    }

    @RequestMapping("/juegos")
    public String games(Model model) {
        model.addAttribute("datetime", new Date());
        return "view/juegos";
    }

    @RequestMapping("/new_game")
    public String newGame(Model model) {
        model.addAttribute("datetime", new Date());
        return "view/livegame";
    }

    @RequestMapping("/jugadores")
    public String players(Model model) {
        model.addAttribute("datetime", new Date());
        return "view/jugadores";
    }

    @RequestMapping("/aboutus")
    public String aboutus(Model model) {
        return "aboutus";
    }

    // Just for testing
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("datetime", new Date());
        return "score";
    }

    // FIXME
    @RequestMapping("/score")
    public String score(Model model) {
        model.addAttribute("title", "Soccer ScoreBoard");
        model.addAttribute("minute", 85);
        model.addAttribute("datetime", new Date());
        return "score";
    }
}
