package com.example.LudoDao;

import javax.ejb.Local;

import com.example.LudoEntities.User;

import com.example.LudoEntities.Game;


@Local
public interface LudoDAOLocal {

	public User findUserByName(String userName);
	
	public String createUser(String userName, String Passwort);
	
	public int createSession(User user);

	public void closeSession(int id);
	
	public Game findGameById(int gameId);
		
}
