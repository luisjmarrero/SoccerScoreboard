package tecnicas.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicas.software.model.Play;
import tecnicas.software.model.PlayType;
import tecnicas.software.repository.PlayRepository;
import tecnicas.software.repository.PlayTypeRepository;

import java.util.List;

/**
 * Created by luisjosemarrero on 4/6/17.
 */
@Service
public class PlayService {

    PlayRepository playRepository;
    PlayTypeRepository playTypeRepository;

    @Autowired
    public PlayService(PlayRepository playRepository, PlayTypeRepository playTypeRepository) {
        this.playRepository = playRepository;
        this.playTypeRepository = playTypeRepository;
    }

    public List<Play> getAll(){
        return playRepository.findAll();
    }

    public List<Play> getByType( String type){
        return playRepository.findByType(type);
    }

    public List<PlayType> geTypes(){
        return playTypeRepository.findTypes();
    }

    public List<Play> create( Play play){
        playRepository.save(play);
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


    public List<Play> getAllOrderedByDate(Integer id) {
        return playRepository.findByGameOrderByDateDesc(id);
    }
}
