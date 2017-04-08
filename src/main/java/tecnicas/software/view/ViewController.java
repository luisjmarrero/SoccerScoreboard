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

    @RequestMapping(value={"", "/", "home"})
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/history")
    public String history(Model model){
        return "history";
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        return "admin";
    }

    @RequestMapping("/aboutus")
    public String aboutus(Model model){
        return "aboutus";
    }
 @RequestMapping("/juegos")
    public String teams(Model model){
        return "view/juegos";
    }

    @RequestMapping("/layout")
    public String layout(Model model){
        return "layout/layout";
    }

    @RequestMapping("/score")
    public String score(Model model){
        model.addAttribute("title", "Soccer ScoreBoard");
        model.addAttribute("minute", 85);
        model.addAttribute("datetime", new Date());
        return "score";
    }
}
