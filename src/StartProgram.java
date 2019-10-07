
import java.util.List;
import java.util.Scanner;

import controller.ListGameHelper;
import model.ListGame;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ListGameHelper lgh = new ListGameHelper();

	private static void addAGame() {
		// TODO Auto-generated method stub
		System.out.print("Enter the name of a game: ");
		String name = in.nextLine();
		System.out.print("Enter a genre: ");
		String genre = in.nextLine();
		System.out.println("Enter the console type: ");
		String console = in.nextLine();

		ListGame toAdd = new ListGame(name, genre, console);
		lgh.insertGame(toAdd);

	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the store to delete: ");
		String store = in.nextLine();
		System.out.print("Enter the item to delete: ");
		String item = in.nextLine();

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Store");
		System.out.println("2 : Search by Item");
		int searchBy = in.nextInt();
		in.nextLine();
		/*
		 * List<ListItem> foundItems; if (searchBy == 1) {
		 * System.out.print("Enter the store name: "); String storeName = in.nextLine();
		 * 
		 * } else { System.out.print("Enter the item: "); String itemName =
		 * in.nextLine();
		 * 
		 * 
		 * }
		 * 
		 * if (!foundItems.isEmpty()) { System.out.println("Found Results."); for
		 * (ListItem l : foundItems) { System.out.println(l.getId() + " : " +
		 * l.toString()); } System.out.print("Which ID to edit: "); int idToEdit =
		 * in.nextInt();
		 * 
		 * ListItem toEdit = lih.searchForItemById(idToEdit);
		 * System.out.println("Retrieved " + toEdit.getItem() + " from " +
		 * toEdit.getStore()); System.out.println("1 : Update Store");
		 * System.out.println("2 : Update Item"); int update = in.nextInt();
		 * in.nextLine();
		 * 
		 * if (update == 1) { System.out.print("New Store: "); String newStore =
		 * in.nextLine(); toEdit.setStore(newStore); } else if (update == 2) {
		 * System.out.print("New Item: "); String newItem = in.nextLine();
		 * toEdit.setItem(newItem); }
		 * 
		 * lih.updateItem(toEdit);
		 * 
		 * } else { System.out.println("---- No results found"); }
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
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
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				// lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<ListGame> allGames = lgh.showAllGames();
		for(ListGame singleGame: allGames) {
			System.out.println(singleGame.returnGameDetails()+"\n");
		}

	}

}
