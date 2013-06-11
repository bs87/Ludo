package com.example.LudoLogin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String passwort;
	
	
	public User() {
		super();
	}
	
	public User(String userName, String passwort) {
		this.userName = userName;
		this.passwort = passwort;
	
	}
	
	

	public String getUserName() {
		return userName;
	}

	public String getPasswort() {
		return passwort;
	}

	

	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	
	
	public String toString() {
		return "Kunde: " + this.getUserName() +"/" + this.getPasswort();
	}
}
