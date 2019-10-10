package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamer")
public class Gamer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GAMER_ID")
	private int id;
	@Column(name="GAMER_NAME")
	private String gamerName;
	
	
	public Gamer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Gamer(int id, String gamerName) {
		super();
		this.id = id;
		this.gamerName = gamerName;
	}


	public Gamer(String gamerName) {
		super();
		this.gamerName = gamerName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGamerName() {
		return gamerName;
	}


	public void setGamerName(String gamerName) {
		this.gamerName = gamerName;
	}


	@Override
	public String toString() {
		return "Gamer [id=" + id + ", gamerName=" + gamerName + "]";
	}
	
	
	
	
}
