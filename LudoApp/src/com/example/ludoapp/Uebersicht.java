package com.example.ludoapp;

import java.util.ArrayList;

import com.example.ludoapp.Settings;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.content.SharedPreferences;
import android.view.Menu;



public class Uebersicht extends ListActivity {
	
	private Button highscore;
	private Button neuesSpiel;
	//LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
    int clickCounter=0;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.uebersicht);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,listItems);
        setListAdapter(adapter);
          
        highscore = (Button) findViewById(R.id.buttonHighscore);
    	
        highscore.setOnClickListener(new OnClickListener(){
    			@Override
    			public void onClick(View v) {
    				Intent nextScreen = new Intent(getApplicationContext(), Highscore.class);	
    				startActivity(nextScreen);
    			}
    		});	
        
        neuesSpiel = (Button) findViewById(R.id.buttonNeuesSpielErstellen); 
        neuesSpiel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), neuesspiel.class);	
				startActivity(nextScreen);
			}
		});	
     
     }
   


	@Override
      protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        Object o = this.getListAdapter().getItem(position);
        String keyword = o.toString();
        //Toast.makeText(this, "Es wurde eine Anfrage an Spielleiter Dummy gesendet " + keyword, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Dummyname   Punkte: 1000 " + position+ id , Toast.LENGTH_SHORT).show();
      }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Dummyname   Punkte: 1000");
        adapter.notifyDataSetChanged();
    }
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    

    
}
    