package com.example.ludoWebservice;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Koopmann
 * Dieses Interface definiert die Schnittstelle zwischen Ludo-Client und -Server.
 * Es wird sowohl als Local- als auch als Remote-Business-Interface benutzt. 
 */

public interface ILudoWebservice {

	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 * @param username
	 * @param password
	 * @return
	 * @throws PasswortUngueltigException 
	 * @throws UsernameUngueltigException 
	 */
	public String getLoginDaten (String Username,String Passwort );
	
	/**
	 * Operation zum Ausloggen. Schliesst die Session des Nutzers.
	 * @param sessionID
	 */
	public void logout();
	
	/**
	 * Operation zum Auslesen aller eigenen Konten
	 * @return
	 */
	public Set<Game> getGameList();
	
		
		
		//public Kunde login(String username, String password);
		
		
		
	/**
	 * Operation zur Abfrage der Teilnehmer
	 * @param gameID
	 * @return
	*/
	public Integer getNumerOfPlayer(Integer gameID);
	
}
