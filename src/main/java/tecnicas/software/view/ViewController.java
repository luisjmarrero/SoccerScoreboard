package tecnicas.software.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Luis Marrero on 5/4/2017.
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("tittle", "Soccer ScoreBoard");
        model.addAttribute("minute", 85);
        model.addAttribute("datetime", new Date());
        return "index";
    }
}
