package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gamer;
import model.ListDetails;
import model.ListGame;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListGameHelper lgh = new ListGameHelper();
		String listName = request.getParameter("listName");
		
		System.out.println("List Name: " +listName);
		
		String gamerName = request.getParameter("gamerName");
		
		String[] selectedGames = request.getParameterValues("allGamesToAdd");
		List<ListGame> selectedGamesInList = new ArrayList<ListGame>();
	//ensure a selection
		if(selectedGames != null && selectedGames.length>0) {
			for(int i =0; i<selectedGames.length; i++){
			ListGame c = lgh.searchForGameById(Integer.parseInt(selectedGames[i]));
		selectedGamesInList.add(c);
			}
		}
	Gamer gamer = new Gamer(gamerName);
	ListDetails sld = new ListDetails(listName, gamer);
	sld.setListOfGames(selectedGamesInList);
	ListDetailsHelper slh = new ListDetailsHelper();
	slh.insertNewListDetails(sld);
	
	
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
