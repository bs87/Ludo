package com.example.LudoDao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.LudoEntities.User;
import com.example.LudoEntities.*;


/**
 * Session Bean implementation class XbankDAO
 */
@Stateless
//@Remote(LudoDAOLocal.class)
public class LudoDAO implements LudoDAOLocal {

	@PersistenceContext//(unitName="PersistenceUnit")
	private EntityManager em;
	
	public User findUserByName(String userName){
		return em.find(User.class, userName);
	}
	
	@Override
	public String createUser(String userName, String Passwort) {
		User User = new User();
		User.setUserName(userName);
		User.setPassword(Passwort);
		em.persist(User);
		return User.getUserName();
	}

	@Override
	public int createSession(int userId) {
		Session Session = new Session();
		Session.setUserId(userId);
		em.persist(Session);
		return Session.getSessionId();
		
		// TODO Auto-generated method stub
	}

	@Override
	public void closeSession(int id) {
		Session session = em.find(Session.class, id);
		em.getTransaction().begin();
		em.remove(session);
		em.getTransaction().commit();
	}		
	
	@Override
	public Game findGameById(int gameId){
		return em.find(Game.class, gameId);
	}
	
	@Override
	public int createGame(int spielErstellerId, int anzahlSpieler) {
		Game Game = new Game();
		Game.setIdSpielErsteller(spielErstellerId);
		Game.setAnzahlSpieler(anzahlSpieler);
		em.persist(Game);
		return Game.getId();
	}
	
	@Override
	public int createGame(int spielErstellerId, int anzahlSpieler, int idSpieler2) {
		Game Game = new Game();
		Game.setIdSpielErsteller(spielErstellerId);
		Game.setAnzahlSpieler(anzahlSpieler);
		Game.setIdSpieler2(idSpieler2);
		em.persist(Game);
		return Game.getId();
	}
	
	@Override
	public int createGame(int spielErstellerId, int anzahlSpieler, int idSpieler2, int idSpieler3) {
		Game Game = new Game();
		Game.setIdSpielErsteller(spielErstellerId);
		Game.setAnzahlSpieler(anzahlSpieler);
		Game.setIdSpieler2(idSpieler2);
		Game.setIdSpieler3(idSpieler3);
		em.persist(Game);
		return Game.getId();
	}
}
