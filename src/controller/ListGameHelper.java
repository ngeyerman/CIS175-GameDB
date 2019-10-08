package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListGame;

public class ListGameHelper {// creates methods to find objects, persist, remove, etc in the database

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GameDB");

	public void insertGame(ListGame lg) { // method to add game to sql database
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lg);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListGame> showAllGames() { // list to show all games in database
		EntityManager em = emfactory.createEntityManager();
		List<ListGame> allGames = em.createQuery("SELECT i FROM ListGame i").getResultList();
		return allGames;
	}

	public void deleteGame(ListGame toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("SELECT lg from ListGame lg WHERE lg.gameName = :selectedGame",
				ListGame.class);

		// sub parameter with date from the toDelete item
		typedQuery.setParameter("selectedGame", toDelete.getGameName());

		// one result
		typedQuery.setMaxResults(1);

		// get result and save into a new list game
		ListGame result = typedQuery.getSingleResult();

		// remove game
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListGame> searchForGameByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.gameName =:selectedName",
				ListGame.class);
		typedQuery.setParameter("selectedName", name);
		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}

	public List<ListGame> searchForGameByGenre(String genre) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.genre =:selectedGenre",
				ListGame.class);
		typedQuery.setParameter("selectedGenre", genre);
		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}

	public List<ListGame> searchForGameByConsole(String console) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select lg from ListGame lg where lg.gameConsole =:selectedConsole", 
				ListGame.class);
		typedQuery.setParameter("selectedConsole", console);

		List<ListGame> foundGames = typedQuery.getResultList();
		em.close();

		return foundGames;
	}

	public ListGame searchForGameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListGame found = em.find(ListGame.class, idToEdit);
		em.close();
		return found;
	}

	public void updateGame(ListGame toEdit) { // update actual database
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}

	public void cleanUp() {
		emfactory.close();
	}

}
