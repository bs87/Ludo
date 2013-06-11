package com.example.LudoOnline;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import com.example.LudoEntities.User;
import com.example.LudoDao.LudoDAOLocal;





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
	
	
	
	@Override
	public String sayhello() {
		String antwort = " Antwort vom Service";
		return antwort;
	}
	
	

	@Override
	public String checklogin(String Username, String Passwort) {
		dao.createUser(Username, Passwort);
		String antwort = "Username: " +Username +" passwort: "+  Passwort;
		return antwort;
	}

}
