package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gamer;
import model.ListDetails;
import model.ListGame;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListGameHelper lgh = new ListGameHelper();
		GamerHelper gh = new GamerHelper();
		
		//search for object to change
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails listToEdit = ldh.searchForListById(idToEdit);
		
		//update list name
		String listName = request.getParameter("listName");
		System.out.println("List Name: " +listName);
		listToEdit.setListName(listName);
		
		//update gamer
		String gamerName = request.getParameter("gamerName");
		Gamer gamer = listToEdit.getGamer();
		gamer.setGamerName(gamerName);
		gh.updateGamer(gamer);
		
		//update list of items
		List<ListGame> previousListOfGames = listToEdit.getListOfGames();
		
		String[] toAdd = request.getParameterValues("gamesToAdd");
		List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
		
		if(toAdd != null && toAdd.length>0) {
			for(int i =0; i < toAdd.length; i++) {
				System.out.println("Adding:" + toAdd[i]);
				ListGame c = lgh.searchForGameById(Integer.parseInt(toAdd[i]));
				selectedGamesInList.add(c);
			}	
			
			previousListOfGames.addAll(selectedGamesInList);
		}
		
		String[] toRemove= request.getParameterValues("currentGames");
		
		if(toRemove != null && toRemove.length > 0) {
			selectedGamesInList = new ArrayList<ListGame>();
			for(int i =0; i < toRemove.length; i++) {
				System.out.println("Removing:" + toRemove[i]);
				for(ListGame g : previousListOfGames) {
					if(g.getId() == Integer.parseInt(toRemove[i])) {
						previousListOfGames.remove(g);
						break;
					}
				}
				/*ListGame c = lgh.searchForGameById(Integer.parseInt(toRemove[i]));
				if(selectedGamesInList.indexOf(c) != -1) {
					System.out.println("Found it:" + toRemove[i]);
					selectedGamesInList.remove(selectedGamesInList.indexOf(c));
				}
				selectedGamesInList.add(c);*/
			}
			//previousListOfGames.removeAll(selectedGamesInList);
		}
		
		listToEdit.setListOfGames(previousListOfGames);
		ldh.updateList(listToEdit);
	
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
