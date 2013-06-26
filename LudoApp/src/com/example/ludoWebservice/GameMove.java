package com.example.ludoWebservice;

public class GameMove extends Game {
	
	private static final long serialVersionUID = 1L;
	
	private int[] field = new int[40];
	private int[][] player = new int [4][9];
	private int sessionID;
	private int leiterInGame;
	private int kicked;
	private int started;
	private int warning; 
	
	
	public GameMove() {
		super();
	}

	public GameMove(Integer gameId) {
		super(gameId);
	}
	
	public GameMove(int[] feld, int[][] spieler, int sessionID){
		this.field = feld;
		this.player = spieler;
		this.sessionID = sessionID;
	}
	
	public GameMove(Integer gameID,int[] feld, int[][] spieler){
		super(gameID);
		this.field = feld;
		this.player = spieler;
	}
	
	public void setField(int feld, int wert){
		this.field[feld] = wert;
	}
	
	public int[] getField(){
		return field;
	}
	
	public void setPlayer(int spieler, int wert){
		this.player[spieler][wert] = 1;
	}
	
	public int[][] getPlayer(){
		return player;
	}
	
	public void setSessionID(int ID){
		this.sessionID = ID;
	}
	
	public int getSessionID(){
		return sessionID;
	}
	
	public void addKickedFlag(int kicked){
		this.kicked = kicked;
	}
	
	public int getKickedFlag(){
		return kicked;
	}
	
	public void addStartedFlag(int started){
		this.started = started;
	}
	
	public int getStartedFlag(){
		return started;
	}
	
	public void addLeiterInGameFlag(int inGame){
		this.leiterInGame = inGame;
	}
	
	public int getaddLeiterInGameFlag(){
		return leiterInGame;
	}
	
	public void setWarning(int warnung){
		this.warning = warnung;
	}
	
	public int getWarning(){
		return warning;
	}
}
