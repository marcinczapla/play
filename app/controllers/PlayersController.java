package controllers;

import model.Player;
import play.libs.Json;
import play.mvc.Controller;
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
            return ok(Json.toJson(p));
        }
        return notFound("nf");
    }

}
