package controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListGame;

/**
 * Servlet implementation class addGameServlet
 */
@WebServlet("/addGameServlet")
public class addGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String console = request.getParameter("console");
		String publisher = request.getParameter("publisher");
		//LocalDate date = LocalDate.parse(request.getParameter("date"));
		
		ListGame lg = new ListGame(name, genre, console, publisher, null);
		ListGameHelper lgh = new ListGameHelper();
		lgh.insertGame(lg);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
