package com.example.LudoOnline;

import com.example.Games.GameResp;
import com.example.SystemResponse.UserLoginRespons;

public interface LudoOnlineIntegration {
	
	public String sayhello();

	public String register(String Username, String Passwort);
	
	public boolean logout(int sessionId);
	
	public UserLoginRespons login(String username, String password);
	
	public Object[] getGameList();
	
	public int createGame(int sessionId, String spielname);
	
	/*public GameResp getSpiel(int gameId);
	
	public int joinGame(int gameID, int sessionId);
	
	public void leaveGame(int gameID, int sessionId);*/
	
	//public String[] getInvites(int gameId);
	
	public void acceptInvite(int gameId, String userName);
	
	public GameResp joinLobby(int gameId, int sessionId);
}

