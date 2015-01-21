package repositories;

import model.Player;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Marcin Czapla on 2015-01-21.
 */
public interface PlayerRepository {

    public List<Player> getAll();
    public Player getById(Long id) throws NoSuchElementException;

    public void addPlayer(Player player);
    public void removePlayer(Player player);
    public void updatePlayer(Player player) throws NoSuchElementException;
}
