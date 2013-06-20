package com.example.LudoDao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.LudoEntities.User;
import com.example.LudoEntities.Game;

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
	public int createSession(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void closeSession(int id) {
		// TODO Auto-generated method stub		
	}		
	
	@Override
	public Game findGameById(int gameId){
		return em.find(Game.class, gameId);
	}
}
