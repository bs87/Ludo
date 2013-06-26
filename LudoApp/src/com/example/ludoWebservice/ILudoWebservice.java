package com.example.ludoWebservice;

import java.util.Set;

public interface ILudoWebservice {
	
	public String getHelloString();
	
	//public String getLoginDaten (String Username,String Passwort );

	public User loginweb(String username, String passwort);

	public boolean logout(int sessionId);

	public Set<Game> getGameList(int sessionId);

	//public Integer getNumberOfPlayer(Integer gameID);
	
	//public Game getGameMove (int gameID);
	
	public User registerWeb(String userName, String Passwort);

	public int createGame(int sessionId, String spielname);
	
	public Game joinGame(int gameID); //joinLobby
	
	public void leaveGame(int gameID);
	
	public void doSpielzug(int figur, int field, int gameID);
	
	public GameMove getSpiel(int gameID);
	
	public int wuerfeln(int gameID);
	
	public void invite(String userName, int gameID);
	
	public Set<User> getUser();
	
	public Set<User> getHighScore();
	
	public void acceptInvite (int gameID);
	/*
	 * 
	 * To-Do
	 * GameMove joinLobby gameID, sessionID
	 * void acceptInvite gameID username
	 * 
	 */
	
}
