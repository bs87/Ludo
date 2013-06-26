package com.example.LudoDao;

/*@author: Florian Kopp;*/

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.LudoEntities.*;


/**
 * Session Bean implementation class XbankDAO
 */
@Stateless
//@Remote(LudoDAOLocal.class)
public class LudoDAO implements LudoDAOLocal {

	@PersistenceContext//(unitName="PersistenceUnit")
	private EntityManager em;
	
	@Override
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
	public User findUserById(int userId){
		return em.find(User.class,userId);
	}
	
	@Override
	public int createUser(String userName, String Passwort) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(Passwort);
		em.getTransaction().begin();
			em.persist(user);
			Query query = em.createQuery("select p from User p where USERNAME = :USERNAME", User.class);
			query.setParameter("USERNAME", userName);
			user = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore = new Highscore(user.getUserId(),0);
			em.persist(userHighscore);
		em.getTransaction().commit();
		em.getTransaction().rollback();
		return  user.getUserId();
	}

	@Override
	public int createSession(int userId) {
		System.out.println("Session erstellen1");
		Session session = new Session();
		session.setUserId(userId);
		em.persist(session);
		
		Query query = em.createQuery("select p from Session p where userId = :userId", Session.class);
		query.setParameter("userId", userId);
		Session session2 = (com.example.LudoEntities.Session) query.getSingleResult();
		System.out.println(findUserById(3).getUserName());
		return session2.getSessionId();
	}
	
	@Override
	public Session findSessionById(int sessionId){
		Session session = em.find(Session.class, sessionId);
		return session;
	}
	
	@Override
	public Session findSessionByUserId(int userId){
		Query query = em.createQuery("select p from Session p where userId = :userId", Session.class);
		query.setParameter("userId", userId);
		Session session2 = (com.example.LudoEntities.Session) query.getSingleResult();
		return session2;
	}

	@Override
	public void closeSession(int id) {
		Session session = em.find(Session.class, id);
		//em.getTransaction().begin();
		em.remove(session);
		//em.getTransaction().commit();
	}		
	
	@Override
	public Game findGameById(int gameId){
		//Ein Spiel anhand der Id suchen. Zurück kommt ein Spielobjekt
		return em.find(Game.class, gameId);
	}
	
	@Override
	public int createGame(int spielerstellerId, String name) {
		//Spiel erstellen, benötigt wird die userId des Spielerstellers. Zurück kommt die SpielId
		System.out.println("CreateGameDao. spielerstellerId=" + spielerstellerId+"name"+ name);

		Game game = new Game(spielerstellerId,name);
		//game.setIdSpielErsteller(spielerstellerId);
		game.setIdSpieler2(0);
		game.setIdSpieler3(0);
		game.setIdSpieler4(0);
		game.setSpielBeendet(false);
		System.out.println("CreateGameDao2. spielerstellerId=" + spielerstellerId+"name"+ name);

		em.persist(game);
		//GameId aus der Datenbank auslesen und zurückgeben
		
		Query query = em.createQuery("select g from Game g where IdspielErsteller = :IdspielErsteller", Game.class);
		query.setParameter("IdspielErsteller", spielerstellerId);
		System.out.println("CreateGameDao3. spielerstellerId=" + spielerstellerId+"name"+ name);

		Game game2 = (com.example.LudoEntities.Game) query.getSingleResult();
		System.out.println("CreateGameDao4. spielerstellerId=" + spielerstellerId+"name"+ game2.getId());

		return game2.getId();
	}
		
	@Override
	public void setSpieler2(int spielId, int idSpieler2){
		//spieler2 setzen
		Game game = em.find(Game.class, spielId);
		game.setIdSpieler2(idSpieler2);
		em.persist(game);
	}
	@Override
	public void setSpieler3(int spielId, int idSpieler3){
		//spieler3 setzen
		Game game = em.find(Game.class, spielId);
		game.setIdSpieler3(idSpieler3);
		em.persist(game);
	}
	@Override
	public void setSpieler4(int spielId, int idSpieler4){
		//spieler4 setzen
		Game game = em.find(Game.class, spielId);
		game.setIdSpieler4(idSpieler4);
		em.persist(game);
	}
	
	@Override
	public void removeSpieler(int spielId, int idSpieler){
		//Ein akzeptierter Spieler verlässt das Spiel bevor es beginnt.
		Game game = em.find(Game.class, spielId);
		if(idSpieler == game.getIdSpieler2()){
			if(game.getIdSpieler3()==0){
				game.setIdSpieler2(0);
			}else{
				game.setIdSpieler2(game.getIdSpieler3());
				if(game.getIdSpieler4()==0){
					game.setIdSpieler3(0);
				}else{
					game.setIdSpieler3(game.getIdSpieler4());
					game.setIdSpieler4(0);
				}
			}
		}
		if(idSpieler == game.getIdSpieler3()){
			if(game.getIdSpieler4()==0){
				game.setIdSpieler3(0);
			}else{
				game.setIdSpieler3(game.getIdSpieler4());
				game.setIdSpieler4(0);
			}				
		}
		if(idSpieler == game.getIdSpieler4()){
			game.setIdSpieler4(0);
		}
		em.persist(game);
	}
	
	@Override
	public void spielBeenden(int spielId, int platzierung1, int platzierung2, int platzierung3, int platzierung4, boolean bisEndeGespielt1, boolean bisEndeGespielt2, boolean bisEndeGespielt3, boolean bisEndeGespielt4){
		//Sicherung des Endzustandes des Spiels zur Archivierung.
		Game game = em.find(Game.class, spielId);
		game.setPlatzierung1(platzierung1);
		game.setPlatzierung2(platzierung2);
		game.setPlatzierung3(platzierung3);
		game.setPlatzierung4(platzierung4);
		game.setBisEndeGespielt1(bisEndeGespielt1);
		game.setBisEndeGespielt2(bisEndeGespielt2);
		game.setBisEndeGespielt3(bisEndeGespielt3);
		game.setBisEndeGespielt4(bisEndeGespielt4);
		game.setSpielBeendet (true);
		em.persist(game);
		
	}
	// Nach einem Spiel werden die aus dem Spielverlauf resultierenden Punkte in die Highscore geladen.
	@Override
	public void updateHighscore(int userId, int punkte){
		Highscore userHighscore = em.find(Highscore.class, userId);
		userHighscore.updatePunkte(punkte);
		em.persist(userHighscore);
	}
	//@Override
	public List <Highscore> getHighscore(){
		Query query = em.createQuery("select h from Highscore h Order By h.punkte DESC");
		ArrayList<Highscore> highscoreList = new ArrayList<Highscore>(query.getResultList());
		return highscoreList;
	}
	public List <Game> getGames(){
		Query query = em.createQuery("select g from Game g",Game.class);
		ArrayList<Game> gamelist = new ArrayList<Game>(query.getResultList());
		return gamelist;
	}

}