package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Player;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-01-18.
 */
public class PlayersController  extends Controller {

    public static Result list(){
        List<Player> players = new ArrayList<>();
        players.add(new Player(1L,"Anna"));
        return ok(Json.toJson(players));
    }

    public static Result show(Long id){
        if(id!=null){
            Player p = new Player(2L, "John");
            if(id.equals(2L))
                return ok(Json.toJson(p));
            else
                return notFound("not found");
        }
        return notFound("nf");
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
