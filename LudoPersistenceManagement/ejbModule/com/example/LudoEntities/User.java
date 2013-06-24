package com.example.LudoEntities;
/*@author: Florian Kopp*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	private String userName;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;		
	}	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId(){
		return this.id;
	}
	
	public String getPassword() {
		return password;
	}		
}
