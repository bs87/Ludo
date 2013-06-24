package com.example.LudoDao;

/*@author: Florian Kopp*/

import javax.ejb.Local;

import java.util.*;
import com.example.LudoEntities.*;


@Local
public interface LudoDAOLocal {

	public User findUserByName(String userName);
	
	public User findUserById(int userId);
	
	public int createUser(String userName, String Passwort);

	public int createSession(int userId);
	
	public void closeSession(int id);
	
	public Session findSessionById(int sessionId);
	
	public Game findGameById(int gameId);
	
	public int createGame(int spielerstellerId);

	public void setSpieler2(int spielId, int idSpieler2);
	
	public void setSpieler3(int spielId, int idSpieler3);
	
	public void setSpieler4(int spielId, int idSpieler4);
	
	public void removeSpieler (int spielId, int spielerId);
	
	public void spielBeenden(int spielId, int platzierung1, int platzierung2, int platzierung3, int platzierung4, boolean bisEndeGespielt1, boolean bisEndeGespielt2, boolean bisEndeGespielt3, boolean bisEndeGespielt4);
	
	public void updateHighscore(int userId, int punkte);
	
	public List <Highscore> getHighscore();		
}
