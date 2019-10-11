package controller;

import java.io.IOException;
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
 * Servlet implementation class listNavigationServlet
 */
@WebServlet("/listNavigationServlet")
public class listNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listNavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {// no button selected
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListById(tempId);
				ldh.deleteItem(listToDelete);
				GamerHelper gh = new GamerHelper();
				gh.deleteGamer(listToDelete.getGamer());
			} catch (NumberFormatException e) {
				System.out.println("you must click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToEdit = ldh.searchForListById(tempId);
				ListGameHelper lgh = new ListGameHelper();
				List<ListGame> allGames = lgh.showAllGames();
				List<ListGame> currentListGames = listToEdit.getListOfGames();

				System.out.println("--------After removing items--------");
				for (int i = allGames.size()-1; i > 0; i--) {
					for (int j = currentListGames.size()-1; j >= 0; j--) {
						if (allGames.get(i).getId() == currentListGames.get(j).getId()) {
							allGames.remove(i);
							if(i==0) break;
							// reset loop
							i--;
							j = currentListGames.size();
						}
					}
				}
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("allGamesToAdd", allGames);
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}
		} else if (act.equals("add list")) {
			
			getServletContext().getRequestDispatcher("/addGamesForListServlet").forward(request, response);
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
