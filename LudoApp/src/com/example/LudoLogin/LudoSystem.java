package com.example.LudoLogin;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Thoene
 * Dieses Interface definiert die Schnittstelle zwischen Onlinebanking-Client und -Server.
 * Es wird sowohl als Local- als auch als Remote-Business-Interface benutzt. 
 */
public interface LudoSystem {
	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 * @param username
	 * @param password
	 * @return
	 * @throws PasswortUngueltigException 
	 * @throws UsernameUngueltigException 
	 */
	public User login(String username, String password);
	
	/**
	 * Operation zum Ausloggen. Schliesst die Session des Nutzers.
	 * @param sessionID
	 */
	public void logout();
	
	
	/**
	 * Operation zum Auslesen aller eigenen Konten
	 * @return
	 */
	
}
