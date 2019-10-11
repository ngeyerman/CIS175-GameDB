// by Neil Geyerman and Daniel Draper, artefacted from Kelli Kleindorfer's lab.
package controller;

import java.util.List;
import javax.persistence.*;

import model.Gamer;

public class GamerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameDB");
	
	// insertGamer - insert provided GAMER entry into the database
	public void insertGamer(Gamer g) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		em.close();
	}
	
	 // showAllGamers - returns a LIST<Gamer> of all GAMER entries in the database
	public List<Gamer> showAllGamers() {
		EntityManager em = emfactory.createEntityManager();
		List<Gamer> allGamers = em.createQuery("SELECT g FROM Gamer g").getResultList();
		return allGamers;
	}

	// searchForGamerByName - find a GAMER type in database from the provided name
	public Gamer searchForGamerByName(String gamerName) {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Gamer> typedQuery = em.createQuery("select g from gamer g where g.gamerName = :selectedName", Gamer.class);
		typedQuery.setParameter("selectedName", gamerName);
		typedQuery.setMaxResults(1);
		
		Gamer found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
	
	// searchForGamerById - find a GAMER type in database from the provided id
	public Gamer searchForGamerById(int id) {
		// create entity manager and open it
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		// locate existing entity by id
		Gamer found = em.find(Gamer.class, id);
		
		// close and return found
		em.close();
		return found;
	}
	
	// updateGamer - updates persistence with toEdit entry
	public void updateGamer(Gamer toEdit) {
		// create entity manager and open it
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		// merge toEdit with existing persistence
		em.merge(toEdit);
		
		// commit and close
		em.getTransaction().commit();
		em.close();
		
	}
	
	// deleteGamer - updates persistence by removing toDelete entry
	public void deleteGamer(Gamer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Gamer> typedQuery = em.createQuery("select gid from Gamer gid where gid.id = :selectedID", Gamer.class);
		// alter query to reflect toDelete's id
		typedQuery.setParameter("selectedID", toDelete.getId());

		// narrow it down to one result
		typedQuery.setMaxResults(1);

		// grab single result
		Gamer result = typedQuery.getSingleResult();

		// delete it from persistence
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
