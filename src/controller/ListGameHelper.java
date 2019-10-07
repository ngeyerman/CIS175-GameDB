package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListGame;

public class ListGameHelper {//creates methods to find objects, persist, remove, etc in the database

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameDB");


	public void insertGame(ListGame lg) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lg);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListGame> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<ListGame> allGames = em.createQuery("SELECT i FROM ListGame i").getResultList();
		return allGames;
	}
}
