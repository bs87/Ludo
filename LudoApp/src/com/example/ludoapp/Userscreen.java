package com.example.ludoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

public class Userscreen extends Activity {
	
	private Button gamelist;	
	private Button highscore;

	   void showToast(CharSequence msg) {
	        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userscreen);
        Intent i = getIntent();
        // Receiving the Data
        TextView Spielername = (TextView) findViewById(R.id.Spielername);
        String Spielername12 = i.getStringExtra("Username");
        Spielername.setText(Spielername12);
        
        gamelist = (Button) findViewById(R.id.buttonGamelist);
		
        gamelist.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent nextScreen = new Intent(getApplicationContext(), Uebersicht.class);	
					startActivity(nextScreen);
				}
			});	
                 
        highscore = (Button) findViewById(R.id.buttonHighscore);
		
        highscore.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent nextScreen = new Intent(getApplicationContext(), Highscore.class);	
					startActivity(nextScreen);
				}
			});	
                        
                    

			

        
        
    }
    
}