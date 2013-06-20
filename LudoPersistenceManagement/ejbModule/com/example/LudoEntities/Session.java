package com.example.LudoEntities;

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
public class Session implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	private int userId;
	
	/**
	 * Bidirektionale Eins-zu-Viele Behiehung
	 * FetchType.LAZY = lazy loading (alternativ: FetchType.EAGER)
	 * @Mapkey benutzt die Id als Key für die Map
	 */
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="owner") @MapKey
	
	public Session() {
		super();
	}
	
	public Session(int userId) {
		this.userId = userId;		
	}	

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}
	
	public int getSessionId() {
		return id;
	}		
}