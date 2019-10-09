package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "list_details")

public class ListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIST_ID")
	private int id;
	@Column(name = "LIST_NAME")
	private String listName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "GAMER_ID")
	private Gamer gamer;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "GAMES_ON_LIST", joinColumns = {
			@JoinColumn(name = "LIST_ID", referencedColumnName = "LIST_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "GAME_ID", referencedColumnName = "ID", unique = true) })

	private List<ListGame> listOfGames;

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, Gamer gamer, List<ListGame> listOfGames) {
		super();
		this.id = id;
		this.listName = listName;
		this.gamer = gamer;
		this.listOfGames = listOfGames;
	}

	public ListDetails(String listName, Gamer gamer, List<ListGame> listOfGames) {
		super();
		this.listName = listName;
		this.gamer = gamer;
		this.listOfGames = listOfGames;
	}

	public ListDetails(String listName, Gamer gamer) {
		super();
		this.listName = listName;
		this.gamer = gamer;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public List<ListGame> getListOfGames() {
		return listOfGames;
	}

	public void setListOfGames(List<ListGame> listOfGames) {
		this.listOfGames = listOfGames;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", gamer=" + gamer + ", listOfGames=" + listOfGames
				+ "]";
	}
	
	

}
