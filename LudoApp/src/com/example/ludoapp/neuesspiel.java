package com.example.ludoapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ludoWebservice.Game;
import com.example.ludoWebservice.ILudoWebservice;
import com.example.ludoWebservice.LudoWebserviceStub;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
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
	private TextView textAnfragen;
	private Button spielStarten;
	private Button spielVeroeffentlichen;
	private Integer number;
	private SparseBooleanArray checkedPositions;
	public String username;
	public String sessionid;
	public int gameid;
	  
	   protected int splashTime = 3000;
       TextView tv1;
       int timer =0;
       int key=0;
       HashMap<String,String> h = new HashMap<String,String>();
       private static final String TAG = neuesspiel.class.getName();
   	   createGame createGame;
   	   ILudoWebservice service; 
   	   sendAcceptAnfrage sendAcceptAnfrage;
       
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
        tv1 = (TextView) findViewById(R.id.textViewHighscore);
        textAnfragen = (TextView) findViewById(R.id.textAnfragen);
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,listItems);
        setListAdapter(adapter);
        checkedPositions = lstView.getCheckedItemPositions ();
      createGame = new createGame();
      sendAcceptAnfrage = new sendAcceptAnfrage();
      
		 Intent i = getIntent();
		    // Receiving the Data
		  username = i.getStringExtra("username");
		  sessionid = i.getStringExtra("sessionid");
      
		  
        spielStarten = (Button) findViewById(R.id.buttonSpielBeitreten);
        spielStarten.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) {
        		//createGame.execute();
        		Intent nextScreen = new Intent(getApplicationContext(), spiel.class);	
        		/*nextScreen.putExtra("Spieler1", Spieler1.getText().toString());
              	nextScreen.putExtra("Spieler2", Spieler2.getText().toString());
              	nextScreen.putExtra("Spieler3", Spieler3.getText().toString());
              	nextScreen.putExtra("Spieler4", Spieler4.getText().toString());
              	nextScreen.putExtra("number", number.toString());*/
        		startActivity(nextScreen);
        	}
		});
        
        
        
        
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
    				createGame.execute();
    				th.start();	
    		}
    	});	
      }
    
    
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
   
    
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      super.onListItemClick(l, v, position, id);
      CheckedTextView check = (CheckedTextView)v;
      // Get the item that was clicked
      Object o = this.getListAdapter().getItem(position);
      String keyword = o.toString();

     // sendAcceptAnfrage.execute(username, gameid);
      
      key=0;
      int size = checkedPositions.size ();
      for (int i=0 ; i<size ; i++) {
    	  if (checkedPositions.get(i)){
    		  key++;
    		     if(h.size()==3){
    		         check.setChecked(false);
    		     }else{
    		    	  h.put( o.toString(),o.toString());
    		     }
    		 
    	  }else{
    		  h.remove( o.toString());
    	  }
    	  tv1.setText(h.size()+"");
    	  if(h.size()==3)
	    	Toast.makeText(this, "Es wurden schon 3 Spieler ausgewählt " , Toast.LENGTH_SHORT).show(); 

    	  for ( String elem : h.keySet() )
    		  Log.d(TAG, elem );
    	  //the item is not checked, do something else
    	}
     ;
    }
  //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
  public void addItems(View v) {
     
  }
  
  
  class sendAcceptAnfrage extends AsyncTask<String, Integer, Integer>{
		
	@Override
	protected void onPostExecute(Integer result) {
					
		
			
		}
	

	@Override
	protected Integer doInBackground(String... params) {
		int Game  = service.createGame(Integer.valueOf(sessionid),username);//(Integer.valueOf(sessionid));
		
		return Game;
		}
		
}
  
  class createGame extends AsyncTask<String, Integer, Integer>{
		
		@Override
		protected void onPostExecute(Integer result) {
						
			
				
			}
		

		@Override
		protected Integer doInBackground(String... params) {
			int game = service.createGame(Integer.valueOf(sessionid),username);//createGame(Integer.valueOf(sessionid));
			
			return game;
			}
			
	}
  
  
 
  
  @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.itemPrefs2 :
				//getGameList.execute();
				//gameid herausfinden 
							
				break;
		}
			
		return true;
	}
   
	@Override
   public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu2, menu);
		//You must return true for the menu to be displayed; if you return false it will not be shown.
		return true;
	}

    
     
        
    }
    
