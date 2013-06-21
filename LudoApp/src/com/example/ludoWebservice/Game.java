package com.example.ludoWebservice;

import java.io.Serializable;
import java.lang.Math;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer gameID;
	private Integer numberOfPlayer;
	
	public Game() {
		super();
	}
	
	public Game(Integer gameID) {
		this.numberOfPlayer = 1;
		this.gameID = gameID;
	}
	
	public Integer getGameID() {
		return gameID;
	}
	
	public Integer getNumberOfPlayer() {
		return numberOfPlayer;
	}
	
	public void increase(Integer amount) {
		this.numberOfPlayer = this.numberOfPlayer + amount;
	}
	
	public void decrease(Integer amount) {
		this.numberOfPlayer = this.numberOfPlayer - amount;
	}
	
	public String toString() {
		return "Spiel " + this.gameID + " (" + this.numberOfPlayer + " Spieler)";
	}

	public void setGameID(Integer gameID) {
		this.gameID = gameID;
	}

	public void setNumberOfPlayer(Integer numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}
}
