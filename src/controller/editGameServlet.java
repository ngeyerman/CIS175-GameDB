package controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListGame;

/**
 * Servlet implementation class editGameServlet
 */
@WebServlet("/editGameServlet")
public class editGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListGameHelper lgh = new ListGameHelper();
		
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String console = request.getParameter("console");
		String publisher = request.getParameter("publisher");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		//LocalDate date = LocalDate.parse(inputDate, formatter);
		
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListGame gameToUpdate = lgh.searchForGameById(tempId);
		gameToUpdate.setGameName(name);
		gameToUpdate.setGenre(genre);
		gameToUpdate.setGameConsole(console);
		gameToUpdate.setPublisher(publisher);
		gameToUpdate.setReleaseDate(ld);
		
		lgh.updateGame(gameToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
		
		
	}

}
