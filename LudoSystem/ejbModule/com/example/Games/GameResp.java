package com.example.Games;

import javax.ejb.EJB;

import com.example.LudoDao.LudoDAOLocal;
import com.example.LudoEntities.User;

public class GameResp {
	
	@EJB(beanName = "LudoDAO", beanInterface = com.example.LudoDao.LudoDAOLocal.class)
	private LudoDAOLocal dao;
	
	private int[] felder = new int[40];
	private int[][] spieler = new int[4][9];
	private String[] spielerNamen = new String[4];
	private int spielid, anzahl = 0, leiterIngame = 1, started = 0, warnung = 0, kicked = 0, amZug = 0, dice;
	private String message;
	
	public GameResp(){	
	}
	
	public GameResp(int leiterid){
		addSpieler(leiterid);
		System.out.println("was ist die Leiterid"+leiterid);

		
	}
	
	public void setKicked(int kicked){
		this.kicked = kicked;
	}
	
	public void setWarnung(int warnung){
		this.warnung = warnung;
	}
	
	public void setFelder(int[] felder){
		for(int i=0; i<40; i++){
			this.felder[i] = felder[i];
		}
	}
	
	public void setSpieler(int[][] spieler){
		for(int i=0; i<4; i++){
			for(int k=0; k<9; k++){
				this.spieler[i][k] = spieler[i][k];
			}
		}
	}
	
	public int[] getFelder(){
		int[] response = new int[40];
		response = this.felder;
		return response;
	}
	
	public int[][] getSpieler(){
		int[][] response = new int[4][9];
		response = this.spieler;
		return response;
	}
	
	public int getLeiterIngame(){
		return this.leiterIngame;
	}
	
	public int getSpielid(){
		return this.spielid;
	}
	
	public int getStarted(){
		return this.started;
	}
	
	public void setStarted(int started){
		this.started = started;
	}
	
	public void setSpielid(int spielid){
		this.spielid = spielid;
	}
	
	public int[] getSpielerids(){
		int[] ids = new int[4];
		for(int i=0; i<anzahl; i--){
			ids[i] = spieler[i][0];
		}
		return ids;
	}
	
	public int getAnzahl(){
		return this.anzahl;
	}
	
	public void addSpieler(int spielerid){
		if(anzahl < 4 & leiterIngame == 1){	
			if(spieler[0][1] != 1){
				spieler[0][0] = spielerid;
				for(int i=1; i<9; i++){
					spieler[0][i] = 1;
				}
				anzahl++;
			}else if(spieler[1][1] != 2){
				spieler[1][0] = spielerid;
				for(int i=1; i<9; i++){
					spieler[1][i] = 2;
				}
				anzahl++;
			}else if(spieler[2][1] != 3){
				spieler[2][0] = spielerid;
				for(int i=1; i<9; i++){
					spieler[2][i] = 3;
				}
				anzahl++;
			}else if(spieler[3][1] != 4){
				spieler[3][0] = spielerid;
				for(int i=1; i<9; i++){
					spieler[3][i] = 4;
				}
				anzahl++;
			}
			System.out.println("was ist in Spieler[0][0] "+ spieler[0][0]);
		}
	}
	
	public void removeSpieler(int spielerid){
		if(spieler[1][0] == spielerid){
			spieler[1][1] = 0;
			anzahl--;
		}else if(spieler[2][0] == spielerid){
			spieler[2][1] = 0;
			anzahl--;
		}else if(spieler[3][0] == spielerid){
			spieler[3][1] = 0;
			anzahl--;
		}else if(spieler[0][0] == spielerid){
			leiterIngame = 0;
		}
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setAmZug(int amZug){
		this.amZug = amZug;
	}
	
	public int getAmZug(){
		return this.amZug;
	}
	
	public int getDice(){
		return this.dice;
	}
	
	public void setDice(int dice){
		this.dice = dice;
	}
	
	public void setSpielerNamen(){
		System.out.println("was ist anzahl"+anzahl);
		System.out.println("was ist spielersteller1"+this.spieler[0][0]);

		//System.out.println("was ist spielersteller2"+ dao.findUserById(2).getUserName());
		dao.setSpieler2(1,7);

		for(int i=0; i<anzahl; i++){	
			System.out.println("hdbwaiawhduawihduwhdiahw");
			System.out.println("was ist spielersteller2-----"+dao.findSessionByUserId(2).getSessionId());
			User testuser = (User)dao.findUserById(this.spieler[i][0]); 
			
			System.out.println("was ist spielersteller3"+testuser.getUserName());

			System.out.println("was ist der Spielername"+spielerNamen[i]);
		}
	}
}
