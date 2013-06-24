package com.example.LudoEntities;
/* @author: Florian Kopp*/

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
	private boolean bisEndeGespielt1 = false;
	private boolean bisEndeGespielt2 = false;
	private boolean bisEndeGespielt3 = false;
	private boolean bisEndeGespielt4 = false;
	private boolean spielBeendet = false;
	
	public Game() {
		super();
	}
	
	public Game(int idSpielErsteller) {
		this.idSpielErsteller = idSpielErsteller;
	}
	
	/* setter Methoden*/
	public void setAnzahlSpieler (int anzahlSpieler){
		this.anzahlSpieler = anzahlSpieler;
	}
	public void setIdSpielErsteller(int idSpielErsteller){
		this.idSpielErsteller = idSpielErsteller;
	}
	
	public void setIdSpieler2(int idSpieler2){
		this.idSpieler2 = idSpieler2;
	}
	
	public void setIdSpieler3(int idSpieler3){
		this.idSpieler3 = idSpieler3;
	}
	
	public void setIdSpieler4(int idSpieler4){
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
	
	public void setBisEndeGespielt1 (boolean bisEngegespielt){
		this.bisEndeGespielt1 = bisEngegespielt;
	}
	
	public void setBisEndeGespielt2 (boolean bisEngegespielt){
		this.bisEndeGespielt2 = bisEngegespielt;
	}
	
	public void setBisEndeGespielt3 (boolean bisEngegespielt){
		this.bisEndeGespielt3= bisEngegespielt;
	}
	
	public void setBisEndeGespielt4 (boolean bisEngegespielt){
		this.bisEndeGespielt4 = bisEngegespielt;
	}
	
	public void setSpielBeendet(boolean spielBeendet){
		this.spielBeendet = spielBeendet;
	}
	
	
	/* Getter Methoden*/
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
	
	public int getIdSpieler2(){
		return idSpieler2;
	}
	public int getIdSpieler3(){
		return idSpieler3;
	}
	public int getIdSpieler4(){
		return idSpieler4;
	}
}