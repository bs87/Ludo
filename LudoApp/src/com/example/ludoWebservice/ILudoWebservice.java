package com.example.ludoWebservice;

import java.util.Set;

public interface ILudoWebservice {
	
	public String getHelloString();
	
	//public String getLoginDaten (String Username,String Passwort );

	public User loginweb(String username, String passwort);

	public void logout();

	public Set<Game> getGameList();

	//public Integer getNumberOfPlayer(Integer gameID);
	
	//public Game getGameMove (int gameID);

	public Game createGame();
	
	public Game joinGame(int gameID);
	
	public void leaveGame(int gameID);
	
	public void doSpielzug(int figur, int field, int gameID);
	
	public GameMove getSpiel(int gameID);
	
	public int wuerfeln();
	
	public void invite(String userName, int gameID);
	
	public Set<User> getUser();
	
	public Set<User> getHighScore();
	
}
