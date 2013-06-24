package com.example.LudoDao;
/*@author:Florian Kopp*/

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.LudoEntities.User;
import com.example.LudoEntities.Highscore;


@Startup
@Singleton
@LocalBean
public class DataBuilder {
	
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	private void init() {
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
		
	}
	
}

