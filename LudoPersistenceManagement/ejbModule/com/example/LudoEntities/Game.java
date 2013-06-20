package com.example.LudoEntities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	private int anzahlSpieler;
	private int idSpielErsteller;
	private int idSpieler2;
	private int idSpieler3;
	private int idSpieler4;
	private int platzierung4;
	private int platzierung3;
	private int platzierung2;
	private int platzierung1;
	
	
	/**
	 * Bidirektionale Eins-zu-Viele Behiehung
	 * FetchType.LAZY = lazy loading (alternativ: FetchType.EAGER)
	 * @Mapkey benutzt die Id als Key für die Map
	 */
	//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="owner") @MapKey
	
	public Game() {
		super();
	}
	
	public Game(int anzahlSpieler, int idSpielErsteller, int idSpieler2) {
		this.anzahlSpieler = anzahlSpieler;
		this.idSpielErsteller = idSpielErsteller;
		this.idSpieler2 = idSpieler2;	
	}	

	public Game(int anzahlSpieler, int idSpielErsteller, int idSpieler2, int idSpieler3) {
		this.anzahlSpieler = anzahlSpieler;
		this.idSpielErsteller = idSpielErsteller;
		this.idSpieler2 = idSpieler2;	
		this.idSpieler3 = idSpieler3;
	}
	
	public Game(int anzahlSpieler, int idSpielErsteller, int idSpieler2, int idSpieler3, int idSpieler4) {
		this.anzahlSpieler = anzahlSpieler;
		this.idSpielErsteller = idSpielErsteller;
		this.idSpieler2 = idSpieler2;	
		this.idSpieler3 = idSpieler3;
		this.idSpieler4 = idSpieler4;
	}
	
	public void setPlatzierung4(int platzierung4){
		this.platzierung4 = platzierung4;
	}

	public void setPlatzierung3(int platzierung3){
		this.platzierung3 = platzierung3;
	}
	
	public void setPlatzierung2(int platzierung2){
		this.platzierung2 = platzierung2;
	}
	
	public void setPlatzierung1(int platzierung1){
		this.platzierung1 = platzierung1;
	}
	public int getId(){
		return id;
	}
	
	public int getPlatzierung4(){
		return platzierung4;
	}
	
	public int getPlatzierung3(){
		return platzierung3;
	}
	
	public int getPlatzierung2(){
		return platzierung2;
	}
	
	public int getPlatzierung1(){
		return platzierung1;
	}
}