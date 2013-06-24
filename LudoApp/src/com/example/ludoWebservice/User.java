package com.example.ludoWebservice;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String passwort;
	private Integer sessionID;
	private Map<Integer,Game> gameList;
	private Integer rank; 
	
	public User() {
		super();
	}
	
	public User(String userName, String passwort, Integer sessionId){
		this.sessionID = sessionId;
		this.userName = userName;
		this.passwort = passwort;
		this.gameList = new HashMap<Integer,Game>();
	}
	
	
	// Konstruktur wird nur für die UserList benötigt. 
	public User (String userName){
		this.userName = userName;
		this.passwort = null;
		this.sessionID = null;
		this.gameList = null;
	}
	
	public User (String userName, int rank){
		this.userName = userName;
		this.passwort = null;
		this.sessionID = null;
		this.gameList = null;
		this.rank = rank;
	}
	
	public void addGame(Game neuesGame) {
		this.gameList.put(neuesGame.getGameID(), neuesGame);
	}

	public String getUserName() {
		return userName;
	}
	
	public Integer getSessionID(){
		return sessionID;
	}
	
	public void setSessionID(Integer sessionId){
		this.sessionID = sessionId;
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
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(Integer rank){
		this.rank = rank;
	}
	
	public String toString() {
		return "Spieler: " + this.getUserName() +"/" + this.getPasswort();
	}	
}
