package tecnicas.software.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecnicas.software.model.Memo;
import tecnicas.software.service.GameService;
import tecnicas.software.service.MemoService;

/**
 * Created by Luis Marrero on 9/4/2017.
 */
@RestController
@RequestMapping(value = {"/memo"})
public class MemoRestController {

    MemoService memoService;

    @Autowired
    public MemoRestController(MemoService memoService) {
        this.memoService = memoService;
    }

    @RequestMapping(value = "/{id}")
    public Memo getById(@PathVariable Integer id) {
        return memoService.getByID(id);
    }

    @RequestMapping(value = "/last", method = RequestMethod.GET)
    public Memo getLast(){
        return memoService.getLast();
    }

    @RequestMapping(value = "/last/{id}", method = RequestMethod.POST)
    public Memo setLast(@PathVariable Integer id){
        System.err.println(id);
        return memoService.seLast(id);
    }

//    @RequestMapping(value = "/last")
//    public Memo setLast(@RequestBody Memo memo){
//        return memoService.seLast(memo);
//    }
}
