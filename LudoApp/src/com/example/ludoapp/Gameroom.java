package com.example.ludoapp;

import java.util.ArrayList;

import com.example.ludoWebservice.Game;



import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.ListActivity;



public class Gameroom extends ListActivity {
   
	private Button anfragestellen;
	private Button spielBeitreten;
	private Button spielRaumVerlassen;
	private int splashTime = 30000;
	//LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.gameroom);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);
		anfragestellen.setEnabled(true);
		spielBeitreten.setEnabled(false);
        for (int i=0; i<5; i++){
        	listItems.add("Platz "+i+":" + "User"+i+": 1000"+i );
            adapter.notifyDataSetChanged();
        	}
        
        anfragestellen = (Button) findViewById(R.id.buttonAnfragestellen);
        anfragestellen.setOnClickListener(new OnClickListener(){
    		@Override
    		public void onClick(View v) {
    			anfragestellen.setEnabled(false);
    				th.start();	
    		}
    	});	
    	
        spielBeitreten = (Button) findViewById(R.id.buttonSpielBeitreten);
        spielBeitreten.setOnClickListener(new OnClickListener(){
     		@Override
     		public void onClick(View v) {
     			
     		}
     	});	
     	
        spielRaumVerlassen = (Button) findViewById(R.id.buttonSpielRaumVerlassen);
        spielRaumVerlassen.setOnClickListener(new OnClickListener(){
     		@Override
     		public void onClick(View v) {
     			//ToDo
     			//spielRaumVerlassen.execute()	
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
        Toast.makeText(this, "Es wurde eine Anfrage an Spielleiter Dummy gesendet " , Toast.LENGTH_SHORT).show();
      }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
    	
    }
    
    
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
    
    // dran denken TH.stop zu machen wenn man das Spiel startet
    final Thread th=new Thread(){
    @Override
    public void run(){
        try
        {
            for (int timer = 0; timer < 7; timer++)
            {
                int waited = 0;
                while(waited < splashTime)
                {
                    Thread.sleep(100);
                    runOnUiThread(new Runnable() { 
                        @Override
                        public void run() {
                            try {
                            	//ToDo
                            //	executegetStatus.execute();
                            
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

/*class executegetStatus extends AsyncTask<String, Integer, Game>{
	
	@Override
	protected void onPostExecute(Game result) {
				if(true){
					spielBeitreten.setEnabled(true);
				}
		
			
		}
	

	@Override
	protected Game doInBackground(String... params) {
		 Game game = service.createGame(Integer.valueOf(sessionid));
		
		return game;
		}
		
}*/

/*class spielraumverlassen extends AsyncTask<String, Integer, Game>{

@Override
protected void onPostExecute(Game result) {
			if(true){
				spielBeitreten.setEnabled(true);
			}
	
		
	}


@Override
protected Game doInBackground(String... params) {
	 Game game = service.createGame(Integer.valueOf(sessionid));
	
	return game;
	}
	
}*/

    
}
      
	
   