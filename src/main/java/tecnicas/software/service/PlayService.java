package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Play;
import tecnicas.software.repository.PlayRepository;

import java.util.List;

/**
 * Created by luisjosemarrero on 4/6/17.
 */
@Service
public class PlayService {

    PlayRepository playRepository;

    @Autowired
    public PlayService(PlayRepository playRepository) {
        this.playRepository = playRepository;
    }

    public List<Play> getAll(){
        return playRepository.findAll();
    }

    public List<Play> getByType( String type){
        return playRepository.findByType(type);
    }

    public List<Play> create( Play player){
        playRepository.save(player);
        return playRepository.findAll();
    }

    public Play updateById( Integer id,  Play player) {
        Play update = playRepository.findOne(id);

        return playRepository.save(update);
    }

    public List<Play> remove(Integer id){
        playRepository.delete(id);
        return playRepository.findAll();
    }


}
