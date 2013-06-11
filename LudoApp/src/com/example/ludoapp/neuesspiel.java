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

public class neuesspiel extends Activity {
	
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
	private Integer number;
	
	   void showToast(CharSequence msg) {
	        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neuesspiel);
        auswahl_anzahl = (TextView) findViewById(R.id.auswahl_anzahl);
        auswahl_anzahl.setText(R.string.auswahl_anzahl);
        
        
        Integer[] items = new Integer[] {2, 3,4};
        final Spinner spinner = (Spinner) findViewById(R.id.anzahl_spieler);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
        android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        
        
        anzahl_spieler = (Spinner) findViewById(R.id.anzahl_spieler);
        
        Spielername1 = (TextView) findViewById(R.id.spielername1); 
        Spielername1.setText(R.string.Spieler1);
        Spieler1 = (EditText) findViewById(R.id.Spieler1);
        
        Spielername2 = (TextView) findViewById(R.id.spielername2);
        Spielername2.setText(R.string.Spieler2);
        Spieler2 = (EditText) findViewById(R.id.Spieler2);
        
        Spielername3 = (TextView) findViewById(R.id.spielername3); 
        Spielername3.setText(R.string.Spieler3);
        Spieler3 = (EditText) findViewById(R.id.Spieler3);
        
        Spielername4 = (TextView) findViewById(R.id.spielername4);
        Spielername4.setText(R.string.Spieler4);
        Spieler4 = (EditText) findViewById(R.id.Spieler4);
  
        
        los = (Button) findViewById(R.id.los);
        los.setText(R.string.los);
        
        
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
		});
        
        spinner.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                    	 number = Integer.parseInt(spinner.getSelectedItem().toString());
                        //showToast("Spinner1: position=" + position + " id=" + id );
                        if (number == 2){
                        	Spielername1.setVisibility(View.VISIBLE);
                        	Spieler1.setVisibility(View.VISIBLE);
                        	
                         	Spielername2.setVisibility(View.VISIBLE);
                        	Spieler2.setVisibility(View.VISIBLE);
                        	
                        	Spielername3.setVisibility(View.INVISIBLE);
                        	Spieler3.setVisibility(View.INVISIBLE);
                        	
                         	Spielername4.setVisibility(View.INVISIBLE);
                        	Spieler4.setVisibility(View.INVISIBLE);
                        }
                        if (number == 3){
                        	Spielername1.setVisibility(View.VISIBLE);
                        	Spieler1.setVisibility(View.VISIBLE);
                        	
                         	Spielername2.setVisibility(View.VISIBLE);
                        	Spieler2.setVisibility(View.VISIBLE);
                        	
                        	Spielername3.setVisibility(View.VISIBLE);
                        	Spieler3.setVisibility(View.VISIBLE);
                        	
                         	Spielername4.setVisibility(View.INVISIBLE);
                        	Spieler4.setVisibility(View.INVISIBLE);
                        }
                        if (number == 4){
                        	Spielername1.setVisibility(View.VISIBLE);
                        	Spieler1.setVisibility(View.VISIBLE);
                        	
                         	Spielername2.setVisibility(View.VISIBLE);
                        	Spieler2.setVisibility(View.VISIBLE);
                        	
                        	Spielername3.setVisibility(View.VISIBLE);
                        	Spieler3.setVisibility(View.VISIBLE);
                        	
                         	Spielername4.setVisibility(View.VISIBLE);
                        	Spieler4.setVisibility(View.VISIBLE);
                        }
                        
                        
                    }

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
                });

        
        
    }
    
}