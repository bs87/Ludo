package com.example.LudoDao;

import javax.ejb.Local;

import com.example.LudoEntities.*;


@Local
public interface LudoDAOLocal {

	public User findUserByName(String userName);
	
	public String createUser(String userName, String Passwort);

	public void closeSession(int id);
	
	public Game findGameById(int gameId);
	
	public int createGame(int SpielerstellerId, int anzahlSpieler);

	public int createGame(int spielErstellerId, int anzahlSpieler, int idSpieler2);
	
	public int createGame(int spielErstellerId, int anzahlSpieler, int idSpieler2, int idSpieler3);
	
	public int createSession(int userId);

		
}
