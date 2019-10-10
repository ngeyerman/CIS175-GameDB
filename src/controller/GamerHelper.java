package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gamer;
import model.ListGame;

public class GamerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameDB");
	
	public void insertGamer(Gamer g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Gamer> showAllGamers() { // list to show all gamer lists in database
		EntityManager em = emfactory.createEntityManager();
		List<Gamer> allGamers = em.createQuery("SELECT g FROM Gamer g").getResultList();
		return allGamers;
	}

	public Gamer searchForGamerByName(String gamerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Gamer> typedQuery = em.createQuery("select g from gamer g where g.gamerName = :selectedName", Gamer.class);
		typedQuery.setParameter("selectedName", gamerName);
		typedQuery.setMaxResults(1);
		
		Gamer found = typedQuery.getSingleResult();
		em.close();
		return found;
		
	}
}
