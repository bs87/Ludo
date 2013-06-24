package com.example.LudoEntities;
/*@author: Florian Kopp*/

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
public class Highscore implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id	private int userId;
	private int punkte = 0;
	
	public Highscore() {
		super();
	}
	
	public Highscore(int userId, int punkte) {
		this.userId = userId;
		this.punkte = punkte;		
	}	

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId(){
		return this.userId;
	}

	public void updatePunkte(int punkte) {
		this.punkte = this.punkte + punkte;
	}
	
	public int getPunkte() {
		return this.punkte;
	}		
}