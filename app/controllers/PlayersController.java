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
        Result result =  badRequest("badRequest");
        if(id!=null){
            try {
                Player p = playerRepository.getById(id);
                result = ok(Json.toJson(p));
            }catch (NoSuchElementException nsee){
                result = notFound("not found");
            }
        }
        return result;
    }

    public static Result delete(Long id){
        if(id!=null){
            Player p = new Player(2L, "John");
            if(id.equals(2L))
                return ok(Json.toJson(p));
            else
                return notFound("not found");
        }
        return notFound("nf");
    }

    public static Result edit() {
        Http.RequestBody body = request().body();
        return ok("Got txt: " + body.asText());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result add() {
        Http.RequestBody body = request().body();
        JsonNode jsonNode = body.asJson();
        Player player = Json.fromJson(jsonNode,Player.class);
        return ok("Got Json: " + body.asJson());
    }
}
