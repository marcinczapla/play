package repositories;

import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Marcin Czapla on 2015-01-21.
 */
public class PlayerRepositorySimpleImpl implements PlayerRepository {

    private List<Player> players = new ArrayList<>();

    public PlayerRepositorySimpleImpl() {
        players.add(new Player(1L, "Anna"));
        players.add(new Player(2L, "John"));
        players.add(new Player(3L, "Peter"));
        players.add(new Player(4L, "Lucy"));
    }

    @Override
    public List<Player> getAll() {
        return players;
    }

    @Override
    public Player getById(Long id) throws NoSuchElementException {
        Player player = players.stream().filter(p -> p.getId().equals(id)).findAny().get();
        return player;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void updatePlayer(Player newPlayer)  throws NoSuchElementException {
        Player player = players.stream().filter(p -> p.getId().equals(newPlayer.getId())).findAny().get();
        player.setName(newPlayer.getName());
    }
}
