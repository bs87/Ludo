package com.example.ludoWebservice;


/**
 * Diese Klasse repraesentiert einen Benutzer vom Type "Spieler"
 * @author Koopmann
 *
 */
public class Visitor extends User {

	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}
	
	public Player(String userName, String passwort) {
		super(userName, passwort);
	}
	
}
