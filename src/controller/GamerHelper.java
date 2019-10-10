package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gamer;
import model.ListDetails;
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
	
	public Gamer searchForGamerById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Gamer found = em.find(Gamer.class, id);
		em.close();
		return found;
	}
	
	public void updateGamer(Gamer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deleteGamer(Gamer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Gamer> typedQuery = em.createQuery("select gid from Gamer gid where gid.id = :selectedID", Gamer.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedID", toDelete.getId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Gamer result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
