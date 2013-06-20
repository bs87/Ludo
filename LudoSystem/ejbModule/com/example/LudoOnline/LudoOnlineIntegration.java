package com.example.LudoOnline;

import java.math.BigDecimal;

import com.example.SystemResponse.LoginResponse;

/**
 * Dieses Business Interface definiert die Schnittstelle zum OnlinebankingSystem der Xbank.
 * 
 * @author Thoene  
 */
public interface LudoOnlineIntegration {
	
	/**
	 * Operation zum Einloggen mit Username und Password.
	 */
	public String sayhello();

	public String checklogin(String Username, String Passwort);
	
	public LoginResponse login(String username, String password);
	
	
	
}

