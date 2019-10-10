package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")

public class ListGame {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="Game_Name")
	private String gameName;
	@Column(name="Genre")
	private String genre;
	@Column(name="Game_Console")
	private String gameConsole;
	@Column(name="Publisher")
	private String publisher;
	@Column(name="Release_Date")
	private LocalDate releaseDate;
	
	
	public ListGame() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListGame(String gameName, String genre, String gameConsole, String publisher,
			LocalDate releaseDate) {
		super();
		this.gameName = gameName;
		this.genre = genre;
		this.gameConsole = gameConsole;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}

	public ListGame(String gameName, String genre, String gameConsole) {
		super();
		this.gameName = gameName;
		this.genre = genre;
		this.gameConsole = gameConsole;
	}
	
	

	public ListGame(String gameName) {
		super();
		this.gameName = gameName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGameConsole() {
		return gameConsole;
	}

	public void setGameConsole(String gameConsole) {
		this.gameConsole = gameConsole;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate date) {
		this.releaseDate = date;
	}
	
	public String returnGameDetails() {
		return " Game -- "+gameName+ " -- Genre -- " +genre+ " -- Console -- " +gameConsole;
				
	}

	@Override
	public String toString() {
		return "ListGame [id=" + id + ", gameName=" + gameName + ", genre=" + genre + ", gameConsole=" + gameConsole
				+ ", publisher=" + publisher + ", releaseDate=" + releaseDate + "]";
	}


	
	
	

	

	
	
	
	
	

	
	
}
