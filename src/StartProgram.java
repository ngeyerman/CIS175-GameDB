// by Neil Geyerman, comments by Daniel Draper, artefacted from Kelli Kleindorfer's lab.
import java.util.List;
import java.util.Scanner;

import controller.ListGameHelper;
import model.ListGame;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ListGameHelper lgh = new ListGameHelper();

	// addAGame() - add a GAME to persistence database via menu-driven interface
	private static void addAGame() {
		// get name/genre/console from user
		System.out.print("Enter the name of a game: ");
		String name = in.nextLine();
		System.out.print("Enter a genre: ");
		String genre = in.nextLine();
		System.out.println("Enter the console type: ");
		String console = in.nextLine();

		// add information to persistence
		ListGame toAdd = new ListGame(name, genre, console);
		lgh.insertGame(toAdd);

	}

	// deleteAGame() - delete a GAME from persistence database via menu-driven interface
	private static void deleteAGame() {
		// get title from user
		System.out.print("Enter the game to delete: ");
		String game = in.nextLine();

		// delete game from persistence
		ListGame toDelete = new ListGame(game);
		lgh.deleteGame(toDelete);
	}

	// editAGame() - edit a GAME in persistence database via menu-driven interface
	private static void editAGame() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Game");
		System.out.println("2 : Search by Genre");
		System.out.println("3 : Search by Console");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListGame> foundGames;
		if (searchBy == 1) {
			System.out.print("Enter the game name: ");
			String name = in.nextLine();
			foundGames = lgh.searchForGameByName(name);

		} else if (searchBy==2){
			System.out.print("Enter the genre: ");
			String genre = in.nextLine();
			foundGames = lgh.searchForGameByGenre(genre);

		}else {
			System.out.println("Enter the console: ");
			String console = in.nextLine();
			foundGames = lgh.searchForGameByConsole(console);
		}

		if (!foundGames.isEmpty()) {
			System.out.println("Found Results.");
			for (ListGame l : foundGames) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListGame toEdit = lgh.searchForGameById(idToEdit);
			System.out.println("Retrieved " + toEdit.getGameName() + " from " + toEdit.getGenre());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Genre");
			System.out.println("3 : Update Console");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Game Name: ");
				String newName = in.nextLine();
				toEdit.setGameName(newName);
			} else if (update == 2) {
				System.out.print("New Genre: ");
				String newGenre = in.nextLine();
				toEdit.setGenre(newGenre);
			} else if(update ==3) {
				System.out.println("New Console: ");
				String newConsole = in.nextLine();
				toEdit.setGameConsole(newConsole);
			}

			lgh.updateGame(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	// main() - program entry point
	public static void main(String[] args) {
		runMenu();

	}

	// runMenu() - menu-driven interface to add, update, delete and maintain persistence gameDB database
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("Welcome to the Video Game database.");
		while (goAgain) {
			System.out.println("*  Select a game:");
			System.out.println("*  1 -- Add a game");
			System.out.println("*  2 -- Edit a game");
			System.out.println("*  3 -- Delete a game");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAGame();
			} else if (selection == 2) {
				editAGame();
			} else if (selection == 3) {
				deleteAGame();
			} else if (selection == 4) {
				viewTheList();
			} else {
				// lih.cleanUp();
				System.out.println("  Thank you. Goodbye!   ");
				goAgain = false;
			}

		}

	}

	// viewTheList() - view persistence database game list
	private static void viewTheList() {
		List<ListGame> allGames = lgh.showAllGames();
		for (ListGame singleGame : allGames) {
			System.out.println(singleGame.returnGameDetails() + "\n");
		}

	}

}
