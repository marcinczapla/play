package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Player;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import repositories.PlayerRepository;
import repositories.PlayerRepositorySimpleImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Marcin on 2015-01-18.
 */
public class PlayersController  extends Controller {

    private static PlayerRepository playerRepository = new PlayerRepositorySimpleImpl();

    public static Result list(){
        List<Player> players = playerRepository.getAll();
        return ok(Json.toJson(players));
    }

    public static Result show(Long id){
        Result result;
        try {
            Player p = playerRepository.getById(id);
            result = ok(Json.toJson(p));
        }catch (NoSuchElementException nsee){
            result = notFound("player not found");
        }
        return result;
    }

    public static Result delete(Long id){
        playerRepository.removeById(id);
        return ok();
    }

    public static Result edit() {
        Player player = Json.fromJson(request().body().asJson(),Player.class);
        playerRepository.updatePlayer(player);
        return created();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result add() {
        Player player = Json.fromJson(request().body().asJson(),Player.class);
        playerRepository.addPlayer(player);
        return created();
    }
}
