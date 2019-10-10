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
		ListDetails toEdit = ldh.searchForListById(idToEdit);
		
		//update list name
		String listName = request.getParameter("listName");
		System.out.println("List Name: " +listName);
		toEdit.setListName(listName);
		
		/*update the date
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
	
		toEdit.setReleaseDate(ld);
		*/
		
		//update gamer
		String gamerName = request.getParameter("gamerName");
		Gamer gamer;
		try {
			gamer = gh.searchForGamerByName(gamerName);
		} catch(NoResultException ex) {
			gamer = new Gamer(gamerName);
		} catch(Exception ex) {
			gamer = new Gamer(gamerName);
		}
		toEdit.setGamer(gamer);
		
		
		//update list of items
		List<ListGame> previousListOfGames = toEdit.getListOfGames();
		
		String[] selectedGames = request.getParameterValues("gamesToAdd");
		List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
		
		if(selectedGames != null && selectedGames.length>0) {
			for(int i =0; i < selectedGames.length; i++) {
			System.out.println(selectedGames[i]);
			ListGame c = lgh.searchForGameById(Integer.parseInt(selectedGames[i]));
			selectedGamesInList.add(c);
			}	
			
			previousListOfGames.addAll(selectedGamesInList);
		}
		
		toEdit.setListOfGames(previousListOfGames);
		ldh.updateList(toEdit);
		
		System.out.println("Success!");
		System.out.println(toEdit.toString());
	
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
