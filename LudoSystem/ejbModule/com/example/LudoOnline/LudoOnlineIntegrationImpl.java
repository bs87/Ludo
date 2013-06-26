package com.example.LudoOnline;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;


import com.example.Games.ActiveGames;
import com.example.Games.GameResp;
import com.example.SystemResponse.UserLoginRespons;
import com.example.Invites.Invites;
import com.example.LudoDao.LudoDAOLocal;
import com.example.LudoEntities.User;


/**
 * @author Thoene
 * Diese Stateless Session Bean implementiert das fuer das OnlineBanking bereitgestellte Interface.
 *
 */
@WebService
@Stateless
@Remote(LudoOnlineIntegration.class)
public  class LudoOnlineIntegrationImpl implements LudoOnlineIntegration {

	/**
	 * EJB zur Abfrage von Customer-Datensätzen
	 * Referenz auf die EJB wird per Dependency Injection gefüllt. 
	 */
	@EJB(beanName = "LudoDAO", beanInterface = com.example.LudoDao.LudoDAOLocal.class)
	private LudoDAOLocal dao;
	
	@EJB
	private ActiveGames activeGames;
	
	@EJB
	private Invites invites;
	
	@Override
	public String sayhello() {
		String antwort = " Antwort vom Service";
		return antwort;
	}
	
	@Override
	public String register(String Username, String Passwort) {
		dao.createUser(Username, Passwort);
		String antwort = "Username: " +Username +" passwort: "+  Passwort;
		return antwort;
	}
	
	public UserLoginRespons login(String username, String password){
		UserLoginRespons response = new UserLoginRespons();
		
		User user = this.dao.findUserByName(username);		
		if (user != null && user.getPassword().equals(password)) {
			int sessionId = dao.createSession(user.getUserId());
			System.out.println("Login erfolgreich. Session=" + sessionId);
			response.setSessionId(sessionId);
		}
		
		return response;
	}
	
	public boolean logout(int sessionId){
		dao.closeSession(sessionId);
		return true;
	}
	
	public int createGame(int sessionId, String spielname){
		System.out.println("CreateGame1. Session=" + sessionId+ spielname);
		System.out.println("CreateGame1. getuserid" + dao.findSessionById(sessionId).getUserId());
		GameResp spiel1 = new GameResp(dao.findSessionById(sessionId).getUserId());
		//Spiel in Datenbank erstellen
		//System.out.println("CreateGame2. Session=" + sessionId+ dao.createGame(dao.findSessionById(sessionId).getUserId(),spielname));
		spiel1.setSpielid(dao.createGame(dao.findSessionById(sessionId).getUserId(),spielname));
		System.out.println("nach setspielid" );
		spiel1.setSpielerNamen();
		System.out.println("nach setspielernamen");
		//Spiel in Hashmap erstellen
		activeGames.addSpiel(spiel1);
		System.out.println("CreateGame3. Session=" + sessionId+ spielname);
		return spiel1.getSpielid();
	}
	
	/*public int joinGame(int gameID, int sessionId){
		GameResp spiel1 = activeGames.findSpielById(gameID);
		if(spiel1.getAnzahl() == 1){
			dao.setSpieler2(gameID, dao.findSessionById(sessionId).getUserId);
		}else if(spiel1.getAnzahl() == 2){
			dao.setSpieler3(gameID, dao.findSessionById(sessionId).getUserId);
		}else if(spiel1.getAnzahl() == 3){
			dao.setSpieler4(gameID, dao.findSessionById(sessionId).getUserId);
		}
		spiel1.addSpieler(dao.findSessionById(sessionId).getUserId);	
		activeGames.updateSpiel(spiel1);
		return spiel1.getSpielid();
	}
	
	public void leaveGame(int gameID, int sessionId){
		dao.removeSpieler(gameID, dao.findSessionById(sessionId).getUserId);
		GameResp spiel1 = activeGames.findSpielById(gameID);
		spiel1.removeSpieler(dao.findSessionById(sessionId).getUserId);
		activeGames.updateSpiel(spiel1);
	}*/
	
	//Objekttyp = GameResp
	public Object[] getGameList(){
		return activeGames.listSpiele();
	}



	@Override
	public void acceptInvite(int gameId, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameResp joinLobby(int gameId, int sessionId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public GameResp updateGame(int gameId){
		return activeGames.findSpielById(gameId);
	}
	
	public String[] getInvites(int gameId){
		return invites.findInvitesById(gameId);
	}
	/*
	public void acceptInvite(int gameId, String userName){
		joinGame(gameId, findSessionByUserId(findUserByName(userName).getUserId()).getSessionId);
	}
	*/
	/*public GameResp getSpiel(int gameId){
		GameResp response = activeGames.findSpielById(gameId);
		return response;
	}	*/
	

}
