package com.example.LudoDao;
/*@author:Florian Kopp*/

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.LudoEntities.Session;
import com.example.LudoEntities.User;
import com.example.LudoEntities.Highscore;
import com.example.LudoEntities.Game;


@Startup
@Singleton
@LocalBean
public class DataBuilder {
	
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	private void init() {
		
		//User anlegen:
			User user1 = new User("flo","123");
			em.persist(user1);
			Query query = em.createQuery("select p from User p where USERNAME = :USERNAME", User.class);
			query.setParameter("USERNAME", "flo");
			user1 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore1 = new Highscore(user1.getUserId(),100);
			em.persist(userHighscore1);			
		
			User user2 = new User("test","123");
			em.persist(user2);
			query.setParameter("USERNAME", "test");
			user2 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore2 = new Highscore(user2.getUserId(),0);
			em.persist(userHighscore2);			

			User user3 = new User("Lukas","123");
			em.persist(user3);
			query.setParameter("USERNAME", "Lukas");
			user3 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore3 = new Highscore(user3.getUserId(),20);
			em.persist(userHighscore3);
			
			User user4 = new User("Lennart","123");
			em.persist(user4);
			query.setParameter("USERNAME", "Lennart");
			user4 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore4 = new Highscore(user4.getUserId(),10);
			em.persist(userHighscore4);
			Session session1 = new Session(user4.getUserId());
			em.persist(session1);
				
			User user5 = new User("Bjoern","123");
			em.persist(user5);
			query.setParameter("USERNAME", "Bjoern");
			user5 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscore5 = new Highscore(user5.getUserId(),80);
			em.persist(userHighscore5);
			Session session2 = new Session(user5.getUserId());
			em.persist(session2);
						

			User user6 = new User("Andre","123");
			em.persist(user6);
			query.setParameter("USERNAME", "Andre");
			user6 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore userHighscorwwe6 = new Highscore(user6.getUserId(),60);
			em.persist(userHighscorwwe6);
			Session session3 = new Session(user6.getUserId());
			em.persist(session3);
			

			User user7 = new User("Sebastian","123");
			em.persist(user7);
			query.setParameter("USERNAME", "Sebastian");
			user7 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore useerHighscore7 = new Highscore(user7.getUserId(),12);
			em.persist(useerHighscore7);
			Session session4 = new Session(user7.getUserId());
			em.persist(session4);
			
			User user8 = new User("Michael","123");
			em.persist(user8);
			query.setParameter("USERNAME", "Michael");
			user8 = (com.example.LudoEntities.User) query.getSingleResult();
			Highscore usserHighscore8 = new Highscore(user8.getUserId(),15);
			em.persist(usserHighscore8);
			Session session5 = new Session(user8.getUserId());
			em.persist(session5);
			
			
			//Games anlegen
			Game game1 = new Game(user4.getUserId(),"TopSpiel");
			game1.setIdSpieler2(user6.getUserId());
			game1.setIdSpieler3(user5.getUserId());
			em.persist(game1);
						
			Game game2 = new Game(user7.getUserId(),"superSpiel");
			game2.setIdSpieler2(user3.getUserId());
			em.persist(game2);

	

	
	
	}
	
}

