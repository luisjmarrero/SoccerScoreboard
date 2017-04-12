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
    GameService gameService;

    @Autowired
    public PlayService(PlayRepository playRepository, PlayTypeRepository playTypeRepository, GameService gameService) {
        this.playRepository = playRepository;
        this.playTypeRepository = playTypeRepository;
        this.gameService = gameService;
    }

    public List<Play> getAll() {
        return playRepository.findAll();
    }

    public List<Play> getByType(String type) {
        return playRepository.findByType(type);
    }

    public List<PlayType> geTypes() {
        return playTypeRepository.findTypes();
    }

    public List<Play> create(Play play) {
        Boolean local = (play.getGame().getTeamA().getTeam_id() == play.getPlayer_a().getTeam().getTeam_id()) ? Boolean.TRUE : Boolean.FALSE;
        play.setLocal(local);
        updateStatistics(play);
        playRepository.save(play);
        return getAllOrderedByDate(play.getGame().getGame_id());
    }

    public Play updateById(Integer id, Play player) {
        Play update = playRepository.findOne(id);
        return playRepository.save(update);
    }

    public List<Play> remove(Integer id) {
        playRepository.delete(id);
        return playRepository.findAll();
    }

    public List<Play> getAllOrderedByDate(Integer id) {
        return playRepository.findByGameOrderByDateDesc(id);
    }

    private void updateStatistics(Play play) {
        Integer aux = new Integer(0);
        if (play.getLocal()) {
            switch (play.getType().getType()) {
                case "Gol":
                    aux = play.getGame().getScore_a();
                    aux++;
                    play.getGame().setScore_a(aux);
                    break;
                case "Fuera de Lugar":
                    aux = play.getGame().getStatistic().getOffside_local();
                    aux++;
                    play.getGame().getStatistic().setOffside_local(aux);
                    break;
                case "Falta":
                    aux = play.getGame().getStatistic().getFouls_local();
                    aux++;
                    play.getGame().getStatistic().setFouls_local(aux);
                    break;
                case "Tarjeta Roja":
                    aux = play.getGame().getStatistic().getRed_local();
                    aux++;
                    play.getGame().getStatistic().setRed_local(aux);
                    break;
                case "Tarjeta Amarilla":
                    aux = play.getGame().getStatistic().getYellow_local();
                    aux++;
                    play.getGame().getStatistic().setYellow_local(aux);
                    break;
                case "Tiro de esquina":
                    aux = play.getGame().getStatistic().getCorner_local();
                    aux++;
                    play.getGame().getStatistic().setCorner_local(aux);
                    break;
            }
        } else {
            switch (play.getType().getType()) {
                case "Gol":
                    aux = play.getGame().getScore_b();
                    aux++;
                    play.getGame().setScore_b(aux);
                    break;
                case "Fuera de Lugar":
                    aux = play.getGame().getStatistic().getOffside_away();
                    aux++;
                    play.getGame().getStatistic().setOffside_away(aux);
                    break;
                case "Falta":
                    aux = play.getGame().getStatistic().getFouls_away();
                    aux++;
                    play.getGame().getStatistic().setFouls_away(aux);
                    break;
                case "Tarjeta Roja":
                    aux = play.getGame().getStatistic().getRed_away();
                    aux++;
                    play.getGame().getStatistic().setRed_away(aux);
                    break;
                case "Tarjeta Amarilla":
                    aux = play.getGame().getStatistic().getYellow_away();
                    aux++;
                    play.getGame().getStatistic().setYellow_away(aux);
                    break;
                case "Tiro de esquina":
                    aux = play.getGame().getStatistic().getCorner_away();
                    aux++;
                    play.getGame().getStatistic().setCorner_away(aux);
                    break;
            }
        }

        gameService.updateGame(play.getGame());
    }
}
