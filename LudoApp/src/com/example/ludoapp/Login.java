package com.example.ludoapp;

import com.example.ludoWebservice.ILudoWebservice;
import com.example.ludoWebservice.LudoWebserviceStub;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends Activity {
private TextView nachricht;


private Button zurueck;
private Button login;
private EditText Username;

ILudoWebservice service; 
sayhellotask hellotask;
getLogintask logintask;
ILudoWebservice service2; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		Username = (EditText) findViewById(R.id.editTextBenutzername);
		zurueck = (Button) findViewById(R.id.buttonZurueck2);
		

		service = new LudoWebserviceStub();
		logintask = new getLogintask();
		
		service2 =  new LudoWebserviceStub();
		hellotask = new sayhellotask();
		hellotask.execute("");
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
					

					logintask.execute();
					//Intent nextScreen = new Intent(getApplicationContext(), Userscreen.class);
					//nextScreen.putExtra("Username", Username.getText().toString());
					//startActivity(nextScreen);
				}
			});	
		

		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	
	class getLogintask extends AsyncTask<String, Integer, String>{

		@Override
		protected void onPostExecute(String result) {
			EditText tv = (EditText)findViewById(R.id.editTextBenutzername);
			tv.setText(result);
			
		}

		@Override
		protected String doInBackground(String... params) {
			String result = service2.getLoginDaten("Test","test2");
			
			return result.toString();
			}
			
	}
	
	

}
