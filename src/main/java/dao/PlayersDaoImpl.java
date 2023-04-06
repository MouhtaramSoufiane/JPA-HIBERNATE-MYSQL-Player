package dao;

import Entities.Player;
import org.jboss.logging.annotations.Param;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersDaoImpl implements IPlayersDao{
    EntityManager entityManager;
    public PlayersDaoImpl() {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UP_PLA");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Player p) {
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        try {
            entityManager.persist(p);
            entityTransaction.commit();


        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public List<Player> findAll() {
        Query query=entityManager.createQuery("select  p from Player p");
        return query.getResultList();
    }

    @Override
    public List<Player> findByName( String mc) {
        Query query=entityManager.createQuery("select  p from Player p where p.nom like :x");
        query.setParameter("x","%"+mc+"%");
        return query.getResultList();
    }

    @Override
    public Player findByID(Long id) {
        return null;
    }

    @Override
    public void update(Player p) {

    }

    @Override
    public void deleteById(Long idP) {
        EntityTransaction entityTransaction= entityManager.getTransaction();
        entityTransaction.begin();
        try {
            String hql = "DELETE FROM Player WHERE id = :id";
            int deletedEntities = entityManager.createQuery(hql)
                    .setParameter("id", idP)
                    .executeUpdate();
            entityTransaction.commit();

        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
        }
        //HIBERNATE QUERY LANGUAGE




    }
}
