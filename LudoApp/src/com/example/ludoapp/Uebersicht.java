package com.example.ludoapp;

import java.util.ArrayList;
import java.util.Set;

import com.example.ludoWebservice.ILudoWebservice;
import com.example.ludoWebservice.LudoWebserviceStub;
import com.example.ludoWebservice.User;
import com.example.ludoWebservice.Game;
import com.example.ludoapp.Settings;
import com.example.ludoapp.Login.loginTask;



import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.content.SharedPreferences;
import android.view.Menu;



public class Uebersicht extends PreferenceActivity    {
	private SharedPreferences prefs;

	private Button highscore;
	private Button neuesSpiel;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private Button logout;
	private PreferenceScreen mPreferenceScreen;
	public String username;
	public String sessionid;
	getGameList getGameList;
	logoutTask logoutTask;
	ILudoWebservice service; 
	public int GameID=0;
	public int NumbeofPlayer=0;
	//LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
    int clickCounter=0;
    private static final String TAG = Uebersicht.class.getName();

    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.uebersicht);

		
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,listItems);
        setListAdapter(adapter);
        mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);
		service = new LudoWebserviceStub();
		 Intent i = getIntent();
		    // Receiving the Data
		  username = i.getStringExtra("username");
		  sessionid = i.getStringExtra("sessionid");
		   
		    
		

		 logoutTask = new logoutTask();
		getGameList = new getGameList();
		 
		//showProgress(true);
		getGameList.execute();
		
			
	

		
        highscore = (Button) findViewById(R.id.buttonHighscore);
    	
        highscore.setOnClickListener(new OnClickListener(){
    			@Override
    			public void onClick(View v) {
    				Intent nextScreen = new Intent(getApplicationContext(), Highscore.class);	
    				startActivity(nextScreen);
    			}
    		});	
        
        
        logout = (Button) findViewById(R.id.buttonLogout);
    	
        logout.setOnClickListener(new OnClickListener(){
    			@Override
    			public void onClick(View v) {
    				
    			 logoutTask.execute();

    				
    			}
    		});	
    
       
        
        neuesSpiel = (Button) findViewById(R.id.buttonNeuesSpielErstellen); 
        neuesSpiel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), neuesspiel.class);
				  nextScreen.putExtra("username", username);
				nextScreen.putExtra("sessionid", sessionid);

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
        //Toast.makeText(this, "In die Lobby von "+o.toString()+ "beitreten" , Toast.LENGTH_SHORT).show();
      Intent nextScreen = new Intent(getApplicationContext(), Gameroom.class);
      
      int s = o.toString().lastIndexOf("ID:");
      int s2 = o.toString().lastIndexOf("Spieler:");
	  String clickedGameID = o.toString().substring  ( s, s2 );
	  nextScreen.putExtra("gameid", clickedGameID);
	  nextScreen.putExtra("sessionid", sessionid);
      startActivity(nextScreen);
      }

    
    
    
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
    
	class logoutTask extends AsyncTask<String, Integer, Boolean>{
		
		@Override
		protected void onPostExecute(Boolean result) {
			Log.d(TAG,""+result);
			
			if (result){
			showToast("Erfolgreich ausgelogt");
				Intent nextScreen = new Intent(getApplicationContext(), Startscreen.class);
				startActivity(nextScreen);
			}else{
				showToast("Logout war nicht erfolgreich");
			}
				
			}
		
		@Override
		protected Boolean doInBackground(String... params) {
			
			Boolean result= service.logout(Integer.valueOf(sessionid));

			return result;
			}
			
	}
    
	class getGameList extends AsyncTask<String, Integer, Set<Game>>{
	
	@Override
	protected void onPostExecute(Set<Game> result) {
		
		for (Game game : result){
			 GameID = game.getGameID();
			 NumbeofPlayer = game.getNumberOfPlayer();
			 listItems.add("Spielleiter: test ID: "+GameID+"         Spieler: "+NumbeofPlayer);
			 String Spieler1 = game.getSpieler1();
			 String Spieler2 = game.getSpieler2();
			 String Spieler3 = game.getSpieler3();
			 String SpielLeiter = game.getSpielLeiter();

		}
        adapter.notifyDataSetChanged();
		//showProgress(false);
		showToast(GameID+"Logout war nicht erfolgreich"+NumbeofPlayer);
			
		}
	

	@Override
	protected Set<Game> doInBackground(String... params) {
		Set<Game> result = service.getGameList(Integer.valueOf(sessionid));
		
		return result;
		}
		
}

    
 
     
    
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}
    
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.itemPrefs2 :
				//getGameList.execute();
				
				ToneGenerator toneGen;
				int type;
				 
				toneGen = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
				type = ToneGenerator.TONE_DTMF_0;
				toneGen.startTone(type) ;
				toneGen.startTone(type) ;
				toneGen.stopTone();
				    
				
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
    