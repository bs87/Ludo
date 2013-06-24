package com.example.ludoWebservice;

public class GameMove extends Game {
	
	private static final long serialVersionUID = 1L;
	
	private int[] field = new int[40];
	private int[][] player = new int [4][9];
	private int sessionID;
	
	
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
}
