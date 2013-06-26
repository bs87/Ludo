package com.example.ludoWebservice;

import java.io.Serializable;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer gameID;
	private String[] spieler = new String[4];
	private Integer numberOfPlayer;
	
	public Game() {
		super();
	}
	
	public Game(Integer gameID) {
		this.gameID = gameID;
	}
	
	public Game(Integer gameID, String spielLeiter){
		this.numberOfPlayer = 1;
		this.gameID = gameID;
		this.numberOfPlayer = 1;
		this.spieler[0] = spielLeiter;
		this.spieler[1] = null;
		this.spieler[2] = null;
		this.spieler[3] = null;
	}
	
	public String addPlayer(String spieler){
		String result;
		if (this.spieler[1]==null){
			this.spieler[1] = spieler;
			this.numberOfPlayer = 2;
			result = "Succesfully enterd the Game!";
		}
		else{
			if(this.spieler[2]==null){
				this.spieler[2]=spieler;
				this.numberOfPlayer = 3;
				result = "Succesfully enterd the Game!";
			}
			else{
				if(this.spieler[3]==null){
					this.spieler[3]=spieler;
					this.numberOfPlayer = 4;
					result = "Succesfully enterd the Game!";
				}
				else{
					result = "Already full :(";
				}
			}
		}
		return result;
	}
	
	public String leaveGame(String spieler){
		String result;
		if (this.spieler[1]==spieler){
			this.spieler[1] = null;
			this.numberOfPlayer = this.numberOfPlayer-1;
			result = "Succesfully left the Game!";
		}
		else{
			if(this.spieler[2]==spieler){
				this.spieler[2]=null;
				this.numberOfPlayer = this.numberOfPlayer-1;
				result = "Succesfully left the Game!";
			}
			else{
				if(this.spieler[3]==spieler){
					this.spieler[3]=null;
					this.numberOfPlayer = this.numberOfPlayer-1;
					result = "Succesfully left the Game!";
				}
				else{
					result = "##error";
				}
			}
		}
		return result;
	}
	
	public Integer getGameID() {
		return gameID;
	}
	
	public Integer getNumberOfPlayer() {
		return numberOfPlayer;
	}
	
	
	public String toString() {
		return "Spiel " + this.gameID + " (" + this.numberOfPlayer + " Spieler) | Spielleiter: " + this.spieler[0];
	}

	public void setGameID(Integer gameID) {
		this.gameID = gameID;
	}
	public String getSpielLeiter (){
		return spieler[0];
	}
	
	public String getSpieler1(){
		return spieler[1];
	}
	
	public String getSpieler2(){
		return spieler[2];
	}
	
	public String getSpieler3(){
		return spieler[3];
	}

	public void setNumberOfPlayer(Integer numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}
}
