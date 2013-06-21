package com.example.LudoDao;



import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		try{
			Query query = em.createQuery("select p from User p where USERNAME = :USERNAME", User.class);
			query.setParameter("USERNAME", userName);
			User user = (com.example.LudoEntities.User) query.getSingleResult();
			return user;
		}catch (Exception e){
			System.err.println("Benutzername nicht vorhanden");
		}
		return null;
	}
	
	@Override
	public int createUser(String userName, String Passwort) {
		User User = new User();
		User.setUserName(userName);
		User.setPassword(Passwort);
		em.persist(User);
		em.close();
		return User.getUserId();
	}

	@Override
	public int createSession(int userId) {
		System.out.println(userId+"UserIDausgabe-------------------------------");
		Session Session = new Session();
		Session.setUserId(userId);
		em.persist(Session);
		
		Query query = em.createQuery("select p from Session p where userId = :userId", Session.class);
		query.setParameter("userId", userId);
		Session session2 = (com.example.LudoEntities.Session) query.getSingleResult();
		System.out.println(session2+"session2-------------------------------");
		em.close();
		return session2.getSessionId();
		
		// TODO Auto-generated method stub
	}

	@Override
	public void closeSession(int id) {
		Session session = em.find(Session.class, id);
		em.getTransaction().begin();
		em.remove(session);
		em.getTransaction().commit();
		em.close();
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
