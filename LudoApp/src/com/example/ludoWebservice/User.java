package com.example.ludoWebservice;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String passwort;
	private Map<Integer,Game> gameList;
	
	public User() {
		super();
	}
	
	public User(String userName, String passwort) {
		this.userName = userName;
		this.passwort = passwort;
		this.gameList = new HashMap<Integer,Game>();
	}
	
	public void addGame(Game neuesGame) {
		this.gameList.put(neuesGame.getGameID(), neuesGame);
	}

	public String getUserName() {
		return userName;
	}

	public String getPasswort() {
		return passwort;
	}

	public Map<Integer,Game> getGameList() {
		return this.gameList;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public void setGameList(Map<Integer, Game> gameList) {
		this.gameList = gameList;
	}
	
	public String toString() {
		return "Spieler: " + this.getUserName() +"/" + this.getPasswort();
	}
}
