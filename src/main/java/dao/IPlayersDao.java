package dao;

import Entities.Player;

import javax.transaction.Transactional;
import java.util.List;

public interface IPlayersDao {
    public void save(Player p);
    public List<Player> findAll();
    public List<Player> findByName(String mc);
    public Player findByID(Long id);
    public void update(Player p);

    public void deleteById(Long idP);
}
