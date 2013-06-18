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

public class Startscreen extends Activity {
private TextView nachricht;

private Button Neues_Spiel;
private Button Login;
private Button Beenden;
private Button Registration;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startscreen);
		
		ImageView image = (ImageView) findViewById(R.id.title_image);
		

		
		
		
		Login = (Button) findViewById(R.id.buttonLogin);
		Registration = (Button) findViewById(R.id.buttonRegistration);
		Beenden = (Button) findViewById(R.id.Beenden);
		//nachricht = (TextView) findViewById(R.id.title);
		
		Login.setText(R.string.buttonLogin);
		Registration.setText(R.string.buttonRegistration);
		Beenden.setText(R.string.Beenden);
		//nachricht.setText(R.string.title);
		
		
		
		Login.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), Login.class);	
				startActivity(nextScreen);
			}
		});
		
		Registration.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent nextScreen = new Intent(getApplicationContext(), Registration.class);	
				startActivity(nextScreen);
			}
		});
		
		
		Beenden.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
			finish();	
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
				
	

	}
	
	
	

