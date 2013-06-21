package com.example.ludoWebservice;

import java.util.Set;

public interface ILudoWebservice {

	
	public String getHelloString();
	
	public String getLoginDaten (String Username,String Passwort );

	public User loginweb(String username, String passwort);

	void logout();

	Set<Game> getGameList();

	Integer getNumberOfPlayer(Integer gameID);
	

}
