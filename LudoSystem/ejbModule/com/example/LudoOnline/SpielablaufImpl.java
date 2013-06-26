package com.example.LudoOnline;

import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.example.Games.ActiveGames;
import com.example.Games.GameResp;
import com.example.LudoDao.LudoDAOLocal;

@WebService
@Stateless
@Remote(Spielablauf.class)
public class SpielablaufImpl implements Spielablauf{
	
	@EJB(beanName = "LudoDAO", beanInterface = com.example.LudoDao.LudoDAOLocal.class)
	private LudoDAOLocal dao;
	
	@EJB
	private ActiveGames activeGames;
	
	public void startGame(int gameId){
		
		GameResp spiel = activeGames.findSpielById(gameId);
		spiel.setStarted(1);
		int aktiveSpieler = spiel.getAnzahl();
		int[] aSpieler = spiel.getSpielerids();
		
		while(aktiveSpieler > 1){
			spiel.setAmZug(nextSpieler(spiel.getAmZug(), aSpieler));
			activeGames.updateSpiel(spiel);
			
			//timer 60 sec
			//getgame alt und neu vergleichen
			//dospielzuggemacht?
			//warnung?
			//kicked?
		}
	}
	
	public int doWuerfeln(int gameId){
		Random generator = new Random();
		int dice = generator.nextInt(6) + 1;
		
		GameResp spiel = activeGames.findSpielById(gameId);
		spiel.setDice(dice);
		
		activeGames.updateSpiel(spiel);
		return dice;
	}
	
	public GameResp doSpielzug(int figur, int feld, int gameId, int sessionId){
		GameResp spiel=null;
		return  spiel;
	}
	
	public int nextSpieler(int amZug, int[] aSpieler){
		if(amZug == 0){
			return amZug = aSpieler[0];
		}else if(amZug == aSpieler[0]){
			if(aSpieler[1] != 0){
				amZug = aSpieler[1];
				return amZug;
			}else if(aSpieler[2] != 0){
				amZug = aSpieler[2];
				return amZug;
			}else{
				amZug = aSpieler[3];
				return amZug;
			}
		}else if(amZug == aSpieler[1]){
			if(aSpieler[2] != 0){
				amZug = aSpieler[2];
				return amZug;
			}else if(aSpieler[3] != 0){
				amZug = aSpieler[3];
				return amZug;
			}else{
				amZug = aSpieler[0];
				return amZug;
			}
		}else if(amZug == aSpieler[2]){
			if(aSpieler[3] != 0){
				amZug = aSpieler[3];
				return amZug;
			}else if(aSpieler[0] != 0){
				amZug = aSpieler[0];
				return amZug;
			}else{
				amZug = aSpieler[1];
				return amZug;
			}
		}else if(amZug == aSpieler[3]){
			if(aSpieler[0] != 0){
				amZug = aSpieler[0];
				return amZug;
			}else if(aSpieler[1] != 0){
				amZug = aSpieler[1];
				return amZug;
			}else{
				amZug = aSpieler[2];
				return amZug;
			}
		}else{
			return 0;
		}
	}



	
}
