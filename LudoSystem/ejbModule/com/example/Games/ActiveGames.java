package com.example.Games;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;



@Singleton
public class ActiveGames{

private HashMap<Integer,GameResp> spiele;
	
	@PostConstruct
	private void post(){
		spiele = new HashMap<>();
	}
	
	@Lock(LockType.READ)
	public GameResp findSpielById(int id){
		return this.spiele.get(id);
	}
	
	@Lock(LockType.READ)
	public Object[] listSpiele(){
		return this.spiele.values().toArray();
	}
	
	@Lock(LockType.WRITE)	
	public void addSpiel(GameResp spiel){
		this.spiele.put(spiel.getSpielid(), spiel);
	}
	
	@Lock(LockType.WRITE)
	public void deleteSpiel(GameResp spiel){
		this.spiele.remove(spiel.getSpielid());
	}
	
	@Lock(LockType.WRITE)
	public void updateSpiel(GameResp spiel){
		deleteSpiel(spiel);
		addSpiel(spiel);
	}
}
