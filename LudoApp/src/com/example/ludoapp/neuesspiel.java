package com.example.ludoapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.app.ListActivity;


public class neuesspiel extends ListActivity {
	
	private Spinner anzahl_spieler;
	private TextView auswahl_anzahl;
	private EditText Spieler1;
	private EditText Spieler2;
	private EditText Spieler3;
	private EditText Spieler4;
	private TextView Spielername1;
	private TextView Spielername2;
	private TextView Spielername3;
	private TextView Spielername4;
	private Button los;
	private Button spielVeroeffentlichen;
	private Integer number;
	private SparseBooleanArray checkedPositions;
	
	
	   void showToast(CharSequence msg) {
	        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	    }
	   
	   protected int splashTime = 3000;
       TextView tv1;
       String[] name = {"A","N","D","R","O","I","D"};
       int timer =0;
       int key=0;
     //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
       ArrayList<String> listItems=new ArrayList<String>();

       //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
       ArrayAdapter<String> adapter;

       //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
       int clickCounter=0;
       
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neuesspiel);
        tv1 = (TextView) findViewById(R.id.textView1);
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,listItems);
        setListAdapter(adapter);
        checkedPositions = lstView.getCheckedItemPositions ();
        /*
        los.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), spiel.class);	
				nextScreen.putExtra("Spieler1", Spieler1.getText().toString());
                nextScreen.putExtra("Spieler2", Spieler2.getText().toString());
                nextScreen.putExtra("Spieler3", Spieler3.getText().toString());
                nextScreen.putExtra("Spieler4", Spieler4.getText().toString());
                nextScreen.putExtra("number", number.toString());
            	startActivity(nextScreen);
			}
		});*/
        
        
        
        
        // dran denken TH.stop zu machen wenn man das Spiel startet
        final Thread th=new Thread(){
        @Override
        public void run(){
            try
            {
                for (timer = 0; timer < 7; timer++)
                {
                	listItems.add("Dummyname"+timer );
                    int waited = 0;
                    while(waited < splashTime)
                    {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() { 
                            @Override
                            public void run() {
                                try {
                                	
                                	adapter.notifyDataSetChanged();  
                                }
                                catch(Exception e) 
                                {
                                    e.printStackTrace();
                                } 
                            }
                        });
                        waited += 100;
                    } 
                    
                }
                
            }catch (InterruptedException e) {
            }

        }
    };
    
                                    	                                                                                     
                
        

        
        spielVeroeffentlichen = (Button) findViewById(R.id.buttonSpielVeroeffentlichen);
    	
        spielVeroeffentlichen.setOnClickListener(new OnClickListener(){
    			@Override
    			public void onClick(View v) {
    				th.start();	
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
      //Toast.makeText(this, "Dummyname   Punkte: 1000 " + position+ id , Toast.LENGTH_SHORT).show();
     key=0;
      int size = checkedPositions.size ();
      for (int i=0 ; i<size ; i++) {
    	  if (checkedPositions.get(i)){
    		  key++;
    		  tv1.setText(""+ key);
    	  }
    	        //the item is not checked, do something else
    	}
     ;
    }
  //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
  public void addItems(View v) {
     
  }

    
     
        
    }
    
