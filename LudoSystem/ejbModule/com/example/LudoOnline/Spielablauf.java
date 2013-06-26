package com.example.LudoOnline;

import com.example.Games.GameResp;

public interface Spielablauf {

	public int doWuerfeln(int gameId);
	
	public GameResp doSpielzug(int figur, int feld, int gameId, int sessionId);
	
	public int nextSpieler(int amZug, int[] aSpieler);
	
}
