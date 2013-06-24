package com.example.ludoapp;



import com.example.ludoWebservice.ILudoWebservice;
import com.example.ludoWebservice.LudoWebserviceStub;
import com.example.ludoWebservice.User;

//import com.example.ludoapp.Registration.registryTask;


import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;


public class Login extends Activity {
private TextView nachricht;


private Button zurueck;
private Button login;
private EditText Username;
private EditText Passwort;
private SharedPreferences prefs;
ILudoWebservice service; 
loginTask loginTask;
String username;
String passwort;
sayhellotask hellotask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		Username = (EditText) findViewById(R.id.editTextBenutzername);
		Passwort = (EditText) findViewById(R.id.editTextPasswort1);
		zurueck = (Button) findViewById(R.id.buttonZurueck2);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);


		service = new LudoWebserviceStub();
		loginTask = new loginTask();
		
		boolean autologin =  Login.this.prefs.getBoolean("autologin", false);
;
		if (autologin){
			Username.setText(Login.this.prefs.getString("username",""));	
			Passwort.setText(Login.this.prefs.getString("password",""));	
		}
		

		zurueck.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent nextScreen = new Intent(getApplicationContext(), Startscreen.class);	
					startActivity(nextScreen);
				}
			});	
		
		login = (Button) findViewById(R.id.buttonLogin1);
		
		login.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					 username = Username.getText().toString();
					 passwort = Passwort.getText().toString();
					
					if (Username.length() != 0  & Passwort.length() != 0){
						//showProgress(true);
						loginTask.execute();
						
						
						//hellotask.execute("");
						}else{
					    showToast("Username und Passwort müssen ausgefüllt sein");
							
						}
					
				}
			});	
		

		
	}

	
	void showToast(CharSequence msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
		}	
		
	class loginTask extends AsyncTask<String, Integer, String>{

		
		
		@Override
		protected void onPostExecute(String result) {
			
			TextView tv = (TextView)findViewById(R.id.textView2);
			
			int s = result.lastIndexOf("/");
			String username2 = result.substring  ( 0, s );
			String id = result.substring(s+1,result.length());
			tv.setText("Username "+username2+" ID: "+id);
			
			if(id.equals("0")){
				showToast("Username oder Passwort falsch");
			}else{
				Intent nextScreen = new Intent(getApplicationContext(), Uebersicht.class);
				nextScreen.putExtra("username", username2);
				nextScreen.putExtra("id", id);
				startActivity(nextScreen);
			}
		}

		@Override
		protected String doInBackground(String... params) {
			User result = service.loginweb(username, passwort);
			int id = result.getSessionID();
			String username = result.getUserName();
			String userinfo = username+"/"+id; 
			return userinfo;
			}
			
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.itemPrefs :
				startActivity(new Intent(this, Settings.class));
				break;
		}
			
		return true;
	}
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		//You must return true for the menu to be displayed; if you return false it will not be shown.
		return true;
	}
	
	
	class sayhellotask extends AsyncTask<String, Void, String>{

		@Override
		protected void onPostExecute(String result) {
			
			TextView tv = (TextView)findViewById(R.id.textView2);
			tv.setText(result);
			
		}

		@Override
		protected String doInBackground(String... params) {
			String result = service.getHelloString();
			
			return result.toString();
			}
			
	}
	

	

}
