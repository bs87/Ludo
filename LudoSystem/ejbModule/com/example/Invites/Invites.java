package com.example.Invites;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;


@Singleton
public class Invites{

	private HashMap<Integer,String[]> invites;
	
	@PostConstruct
	private void post(){
		invites = new HashMap<>();
	}
	
	@Lock(LockType.READ)
	public String[] findInvitesById(int gameId){
		return this.invites.get(gameId);
	}
	
	@Lock(LockType.WRITE)
	public void addInvite(int gameId ,String userName){
		if(invites.containsKey(gameId)){
			String[] invAlt = new String[findInvitesById(gameId).length];
			String[] invNeu = new String[(findInvitesById(gameId).length)+1];
			invAlt = findInvitesById(gameId);
			invNeu = invAlt;
			invNeu[invAlt.length] = userName;
			this.invites.remove(gameId);
			this.invites.put(gameId, invNeu);
		}else{
			String[] inv = new String[1];
			inv[0] = userName;
			this.invites.put(gameId, inv);
		}
	}
	
	@Lock(LockType.WRITE)
	public void deleteInvites(int gameId){
		this.invites.remove(gameId);
	}
}