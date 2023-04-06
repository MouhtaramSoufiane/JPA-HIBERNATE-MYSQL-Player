package Test;

import Entities.Player;
import dao.PlayersDaoImpl;

import java.util.List;

public class TestEntities {
    public static void main(String[] args) {
        PlayersDaoImpl playersDao = new PlayersDaoImpl();
//        playersDao.save(new Player(null,"RONALDO","CRISTIANO","ALNASSER FC"));
        List<Player> players = playersDao.findByName("MOU");
        players.forEach(player -> {
            System.out.println("************************");
            System.out.println(player.getId());
            System.out.println(player.getPrenom());
            System.out.println(player.getNom());
            System.out.println(player.getClub());
        });
        playersDao.deleteById(3L);

    }}