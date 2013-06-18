package com.example.ludoapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
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

public class spiel extends Activity implements OnClickListener {
	private TextView WuerfelZahl;
	Button[]  area = new Button[190];
	int i1;
	int spieler = 0;
	int wuerfelcounter = 0;
String ButtonText;
	int farbe = 0xFFf5f5f5;
	Integer anzahl;
   	int min = 1;
	int max = 6;
	Button Spieler1,Spieler2,Spieler3,Spieler4;
	
	 void showToast(CharSequence msg) {
	        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	    }
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.spiel);
	        
	        
	        WuerfelZahl = (TextView) findViewById(R.id.WuerfelZahl);
	 
	        area[150] = (Button) findViewById(R.id.button150);
			area[151] = (Button) findViewById(R.id.button151);
			area[152] = (Button) findViewById(R.id.button152);
			area[153] = (Button) findViewById(R.id.button153);
			area[154] = (Button) findViewById(R.id.button154);
			area[155] = (Button) findViewById(R.id.button155);
			area[156] = (Button) findViewById(R.id.button156);
			area[157] = (Button) findViewById(R.id.button157);
			area[158] = (Button) findViewById(R.id.button158);
			area[159] = (Button) findViewById(R.id.button159);
			area[160] = (Button) findViewById(R.id.button160);
			area[161] = (Button) findViewById(R.id.button161);
			area[162] = (Button) findViewById(R.id.button162);
			area[163] = (Button) findViewById(R.id.button163);
			area[164] = (Button) findViewById(R.id.button164);
			area[165] = (Button) findViewById(R.id.button165);
			area[166] = (Button) findViewById(R.id.button166);
			area[167] = (Button) findViewById(R.id.button167);
			area[168] = (Button) findViewById(R.id.button168);
			area[169] = (Button) findViewById(R.id.button169);
			area[170] = (Button) findViewById(R.id.button170);
			area[171] = (Button) findViewById(R.id.button171);
			area[172] = (Button) findViewById(R.id.button172);
			area[173] = (Button) findViewById(R.id.button173);
			area[174] = (Button) findViewById(R.id.button174);
			area[175] = (Button) findViewById(R.id.button175);
			area[176] = (Button) findViewById(R.id.button176);
			area[177] = (Button) findViewById(R.id.button177);
			area[178] = (Button) findViewById(R.id.button178);
			area[179] = (Button) findViewById(R.id.button179);
			area[180] = (Button) findViewById(R.id.button180);
			area[181] = (Button) findViewById(R.id.button181);
			area[182] = (Button) findViewById(R.id.button182);
			area[183] = (Button) findViewById(R.id.button183);
			area[184] = (Button) findViewById(R.id.button184);
			area[185] = (Button) findViewById(R.id.button185);
			area[186] = (Button) findViewById(R.id.button186);
			area[187] = (Button) findViewById(R.id.button187);
			area[188] = (Button) findViewById(R.id.button188);
			area[189] = (Button) findViewById(R.id.button189);
			
			area[1] = (Button) findViewById(R.id.buttonRed1);
			area[2] = (Button) findViewById(R.id.buttonRed2);
			area[3] = (Button) findViewById(R.id.buttonRed3);
			area[4] = (Button) findViewById(R.id.buttonRed4);
        
			
			area[5] = (Button) findViewById(R.id.buttonYellow1);
			area[6] = (Button) findViewById(R.id.buttonYellow2);
			area[7] = (Button) findViewById(R.id.buttonYellow3);
			area[8] = (Button) findViewById(R.id.buttonYellow4);
			
			area[9] = (Button) findViewById(R.id.buttonGreen1);
			area[10] = (Button) findViewById(R.id.buttonGreen2);
			area[11] = (Button) findViewById(R.id.buttonGreen3);
			area[12] = (Button) findViewById(R.id.buttonGreen4);
			
			area[13] = (Button) findViewById(R.id.buttonBlue1);
			area[14] = (Button) findViewById(R.id.buttonBlue2);
			area[15] = (Button) findViewById(R.id.buttonBlue3);
			area[16] = (Button) findViewById(R.id.buttonBlue4);
	        
			area[21] = (Button) findViewById(R.id.buttonTargetR1);
			area[22] = (Button) findViewById(R.id.buttonTargetR2);
			area[23] = (Button) findViewById(R.id.buttonTargetR3);
			area[24] = (Button) findViewById(R.id.buttonTargetR4);
			
			area[31] = (Button) findViewById(R.id.buttonTargetY1);
			area[32] = (Button) findViewById(R.id.buttonTargetY2);
			area[33] = (Button) findViewById(R.id.buttonTargetY3);
			area[34] = (Button) findViewById(R.id.buttonTargetY4);
			
			area[41] = (Button) findViewById(R.id.buttonTargetG1);
			area[42] = (Button) findViewById(R.id.buttonTargetG2);
			area[43] = (Button) findViewById(R.id.buttonTargetG3);
			area[44] = (Button) findViewById(R.id.buttonTargetG4);
			
			area[51] = (Button) findViewById(R.id.buttonTargetB1);
			area[52] = (Button) findViewById(R.id.buttonTargetB2);
			area[53] = (Button) findViewById(R.id.buttonTargetB3);
			area[54] = (Button) findViewById(R.id.buttonTargetB4);
	        
	        
    Intent i = getIntent();
    // Receiving the Data
     anzahl = Integer.parseInt(i.getStringExtra("number").toString());
    String Spieler1name = i.getStringExtra("Spieler1");
    String Spieler2name = i.getStringExtra("Spieler2");
    String Spieler3name = i.getStringExtra("Spieler3");
    String Spieler4name = i.getStringExtra("Spieler4");
    
    
	 Button Spieler1 = (Button) findViewById(R.id.Spieler1);
	 Button Spieler2 = (Button) findViewById(R.id.Spieler2);
	 Button Spieler3 = (Button) findViewById(R.id.Spieler3);
	 Button Spieler4 = (Button) findViewById(R.id.Spieler4);
 	Button Wuerfel = (Button) findViewById(R.id.Wuerfel);
 	
 	// team rot
 	
 	Button button1 = (Button) findViewById(R.id.buttonRed1);
 	Button button2 = (Button) findViewById(R.id.buttonRed2);
	Button button12 = (Button) findViewById(R.id.buttonRed3);
 	Button button13 = (Button) findViewById(R.id.buttonRed4);
 	
 	
 	
 	button1.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button2.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button12.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button13.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);

 	Button button57 = (Button) findViewById(R.id.buttonTargetR1);
 	Button button58 = (Button) findViewById(R.id.buttonTargetR2);
	Button button59 = (Button) findViewById(R.id.buttonTargetR3);
 	Button button60 = (Button) findViewById(R.id.buttonTargetR4);
 	
 	button57.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button58.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button59.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	button60.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	
 	// team blau
 	
 	Button button10 = (Button) findViewById(R.id.buttonYellow1);
 	Button button11 = (Button) findViewById(R.id.buttonYellow2);
	Button button21 = (Button) findViewById(R.id.buttonYellow3);
 	Button button22 = (Button) findViewById(R.id.buttonYellow4);
 	
 	button10.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button11.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button21.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button22.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	
 	Button button17 = (Button) findViewById(R.id.buttonTargetY1);
 	Button button28 = (Button) findViewById(R.id.buttonTargetY2);
	Button button39 = (Button) findViewById(R.id.buttonTargetY3);
 	Button button50 = (Button) findViewById(R.id.buttonTargetY4);
 	
 	button17.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button28.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button39.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	button50.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	
 	// team grün
 	
 	Button button109 = (Button) findViewById(R.id.buttonGreen1);
 	Button button110 = (Button) findViewById(R.id.buttonGreen2);
	Button button120 = (Button) findViewById(R.id.buttonGreen3);
 	Button button121 = (Button) findViewById(R.id.buttonGreen4);
 	
 	button109.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button110.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button120.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button121.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	
 	Button button62 = (Button) findViewById(R.id.buttonTargetG4);
 	Button button63 = (Button) findViewById(R.id.buttonTargetG3);
	Button button64 = (Button) findViewById(R.id.buttonTargetG1);
 	Button button65 = (Button) findViewById(R.id.buttonTargetG2);
 	
 	button62.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button63.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button64.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	button65.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	
 	// team gelb
 	
 	Button button100 = (Button) findViewById(R.id.buttonBlue1);
 	Button button101 = (Button) findViewById(R.id.buttonBlue2);
	Button button111 = (Button) findViewById(R.id.buttonBlue3);
 	Button button112 = (Button) findViewById(R.id.buttonBlue4);
 	
 	button100.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button101.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button111.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button112.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	
 	Button button105 = (Button) findViewById(R.id.buttonTargetB1);
 	Button button94= (Button) findViewById(R.id.buttonTargetB2);
	Button button83 = (Button) findViewById(R.id.buttonTargetB3);
 	Button button72 = (Button) findViewById(R.id.buttonTargetB4);
 	
 	button105.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button94.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button83.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	button72.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	

 	
 	// Spieler
 	
 	
 	Spieler1.getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
 	Spieler2.getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
 	Spieler3.getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
 	Spieler4.getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
 	
    Spieler1.setText(Spieler1name);
    Spieler2.setText(Spieler2name);
    Spieler3.setText(Spieler3name);
    Spieler4.setText(Spieler4name);
    Spieler1.setText(Spieler1name);
    Wuerfel.setText(R.string.Wuerfel);

    
    
    
if (anzahl==2){
	Spieler3.setVisibility(View.INVISIBLE);
	Spieler4.setVisibility(View.INVISIBLE);
}

if (anzahl==3){
	Spieler4.setVisibility(View.INVISIBLE);
}


	


}
	   public void wuerfeln(View v) {
		   Button Spieler1 = (Button) findViewById(R.id.Spieler1);
			 Button Spieler2 = (Button) findViewById(R.id.Spieler2);
			 Button Spieler3 = (Button) findViewById(R.id.Spieler3);
			 Button Spieler4 = (Button) findViewById(R.id.Spieler4);
		 
		
			Random r = new Random();
			i1 = r.nextInt(max - min + 1) + min;
			WuerfelZahl.setText(""+i1);
			if (checkplayer(spieler)){
				if (wuerfelcounter == 3){
					spieler++;
					
					wuerfelcounter=0;
				}
				wuerfelcounter++;					
			}else{
			spieler++;
			}
			  if (spieler > anzahl){
				   spieler=0;
		   }
            //showToast("Spieler: " + spieler + " muss eine Figure bewegen");
            if (spieler == 1){
               	Spieler1.setEnabled(true);
            	Spieler2.setEnabled(false);
				Spieler3.setEnabled(false);
				Spieler4.setEnabled(false);
			}

            if (spieler == 2){
    			Spieler1.setEnabled(false);
    			Spieler2.setEnabled(true);
    			Spieler3.setEnabled(false);
    			Spieler4.setEnabled(false);
    			}
            
            if (spieler == 3){
    			Spieler1.setEnabled(false);
    			Spieler2.setEnabled(false);
    			Spieler3.setEnabled(true);
    			Spieler4.setEnabled(false);
    			}
            
            if (spieler == 4){
    			Spieler1.setEnabled(false);
    			Spieler2.setEnabled(false);
    			Spieler3.setEnabled(false);
    			Spieler4.setEnabled(true);
    			}
	   }
	
	   public void goButtonClickedYellow(View v) {
		   ButtonText = area[150].getText().toString();

		   if (i1 == 6 && ButtonText.equals(" ") ){
		   switch(v.getId()){

		   case R.id.buttonYellow1:
			ButtonText = area[5].getText().toString();
		   area[5].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[5].setText("");
		   area[150].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
		   area[150].setText(ButtonText);
		   break; 
		   
		   case R.id.buttonYellow2:
			   ButtonText = area[6].getText().toString();
		   area[6].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[6].setText("");
		   area[150].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
		   area[150].setText(ButtonText);
		   break;
		   
		   case R.id.buttonYellow3:
		    ButtonText = area[7].getText().toString();
		   area[7].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[7].setText("");
		   area[150].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
		   area[150].setText(ButtonText);
		   break;
		   
		   case R.id.buttonYellow4:
			   ButtonText = area[8].getText().toString();
		   area[8].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[8].setText("");
		   area[150].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
		   area[150].setText(ButtonText);
		   break;
		   }
	   }
	   }
	   
	   public void goButtonClickedGreen(View v) {
		   ButtonText = area[160].getText().toString();

		   if (i1 == 6 && ButtonText.equals(" ") ){
		   switch(v.getId()){

		   case R.id.buttonGreen1:
			   ButtonText = area[9].getText().toString();
		   area[9].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[9].setText(" ");
		   area[160].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
		   area[160].setText(ButtonText);
		   break; 
		   
		   case R.id.buttonGreen2:
			   ButtonText = area[10].getText().toString();
		   area[10].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[10].setText(" ");
		   area[160].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
		   area[160].setText(ButtonText);
		   break;
		   
		   case R.id.buttonGreen3:
		    ButtonText = area[11].getText().toString();
		   area[11].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[11].setText(" ");
		   area[160].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
		   area[160].setText(ButtonText);
		   break;
		   
		   case R.id.buttonGreen4:
			   ButtonText = area[12].getText().toString();
		   area[12].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[12].setText(" ");
		   area[160].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
		   area[160].setText(ButtonText);
		   break;
		   }
	   }
	   }
	   
	   
	   public void goButtonClickedBlue(View v) {
		   ButtonText = area[170].getText().toString();

		   if (i1 == 6 && ButtonText.equals(" ") ){
		   switch(v.getId()){

		   case R.id.buttonBlue1:
			   ButtonText = area[13].getText().toString();
		   area[13].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[13].setText(" ");
		   area[170].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
		   area[170].setText(ButtonText);
		   break; 
		   
		   case R.id.buttonBlue2:
			   ButtonText = area[14].getText().toString();
		   area[14].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[14].setText(" ");
		   area[170].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
		   area[170].setText(ButtonText);
		   break;
		   
		   case R.id.buttonBlue3:
		    ButtonText = area[15].getText().toString();
		   area[15].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[15].setText(" ");
		   area[170].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
		   area[170].setText(ButtonText);
		   break;
		   
		   case R.id.buttonBlue4:
			   ButtonText = area[16].getText().toString();
		   area[16].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[16].setText(" ");
		   area[170].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
		   area[170].setText(ButtonText);
		   break;
		   }
	   }
	   }
	   
	   
	   
	   public void goButtonClickedRed(View v) {
		   ButtonText = area[180].getText().toString();

		   if (i1 == 6 && ButtonText.equals(" ") ){
		   switch(v.getId()){

		   case R.id.buttonRed1:
			   ButtonText = area[1].getText().toString();
		   area[1].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[1].setText(" ");
		   area[180].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
		   area[180].setText(ButtonText);
		   break; 
		   
		   case R.id.buttonRed2:
			   ButtonText = area[2].getText().toString();
		   area[2].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[2].setText(" ");
		   area[180].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
		   area[180].setText(ButtonText);
		   break;
		   
		   case R.id.buttonRed3:
		    ButtonText = area[3].getText().toString();
		   area[3].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[3].setText(" ");
		   area[180].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
		   area[180].setText(ButtonText);
		   break;
		   
		   case R.id.buttonRed4:
			   ButtonText = area[4].getText().toString();
		   area[4].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
		   area[4].setText(" ");
		   area[180].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
		   area[180].setText(ButtonText);
		   break;
		   }
	   }
	   }
	   
public void goButtonClicked(View v) {

if (spieler == 1){
	 farbe = 0xFFFE2E2E;
}
if (spieler == 2){
	 farbe = 0xFFFFFF00;
}
if (spieler == 3){
	 farbe = 0xFF008000;
}
if (spieler == 4){
	 farbe = 0xFF0000FF;
}
			
switch(v.getId()){

case R.id.button150:
move(150,farbe);
break;

case R.id.button151:
	move(151,farbe);
	break;
	
case R.id.button152:
	move(152,farbe);
	break;
	
case R.id.button153:
	move(153,farbe);
	break;

case R.id.button154:
	if(ButtonText.contains("G") && i1 == 6 ){
	moveTarget(154,farbe);		
	}else{
	move(154,farbe);
	}
	break;
case R.id.button155:
	if(ButtonText.contains("G") && ( i1 == 6 || i1== 5) ){
	moveTarget(155,farbe);		
	}else{
	move(155,farbe);
		}
	break;
case R.id.button156:
	if(ButtonText.contains("G") && ( i1 == 6 || i1== 5 || i1== 4) ){
	moveTarget(156,farbe);		
	}else{
	move(156,farbe);
		}
	break;
case R.id.button157:
	if(ButtonText.contains("G") && ( i1 == 6 || i1== 5 || i1== 4 || i1== 3) ){
	moveTarget(157,farbe);		
	}else{
	move(157,farbe);
	}
	break;
case R.id.button158:
	if(ButtonText.contains("G") && ( i1 == 5 || i1== 4 || i1== 3 || i1== 2) ){
	moveTarget(158,farbe);		
	}else{
	move(158,farbe);
	}
	break;
case R.id.button159:
	if(ButtonText.contains("G") && ( i1 == 4 || i1== 3 || i1== 2 || i1== 1) ){
	moveTarget(159,farbe);		
	}else{
	move(159,farbe);
	}
	break;
case R.id.button160:	
	move(160,farbe);
	break;
case R.id.button161:
	move(161,farbe);
	break;
case R.id.button162:
	move(162,farbe);
	break;
case R.id.button163:
	move(163,farbe);
	break;
case R.id.button164:
	if(ButtonText.contains("B") && i1 == 6 ){
	moveTarget(164,farbe);		
	}else{
	move(164,farbe);
	}
	break;
case R.id.button165:
	if(ButtonText.contains("B") && ( i1 == 6 || i1== 5) ){
	moveTarget(165,farbe);		
	}else{
	move(165,farbe);
		}
	break;
case R.id.button166:
	if(ButtonText.contains("B") && ( i1 == 6 || i1== 5 || i1== 4) ){
	moveTarget(166,farbe);		
	}else{
	move(166,farbe);
		}
	break;
case R.id.button167:
	if(ButtonText.contains("B") && ( i1 == 6 || i1== 5 || i1== 4 || i1== 3) ){
	moveTarget(167,farbe);		
	}else{
	move(167,farbe);
	}
	break;
case R.id.button168:
	if(ButtonText.contains("B") && ( i1 == 5 || i1== 4 || i1== 3 || i1== 2) ){
	moveTarget(168,farbe);		
	}else{
	move(168,farbe);
	}
	break;
case R.id.button169:
	if(ButtonText.contains("B") && ( i1 == 4 || i1== 3 || i1== 2 || i1== 1) ){
	moveTarget(169,farbe);		
	}else{
	move(169,farbe);
	}
	break;
case R.id.button170:
	move(170,farbe);
	break;
case R.id.button171:
	move(171,farbe);
	break;
case R.id.button172:
	move(172,farbe);
	break;
case R.id.button173:
	move(173,farbe);
	break;
case R.id.button174:
	if(ButtonText.contains("R") && i1 == 6 ){
	moveTarget(174,farbe);		
	}else{
	move(174,farbe);
	}
	break;
case R.id.button175:
	if(ButtonText.contains("R") && ( i1 == 6 || i1== 5) ){
	moveTarget(175,farbe);		
	}else{
	move(175,farbe);
		}
	break;
case R.id.button176:
	if(ButtonText.contains("R") && ( i1 == 6 || i1== 5 || i1== 4) ){
	moveTarget(176,farbe);		
	}else{
	move(176,farbe);
		}
	break;
case R.id.button177:
	if(ButtonText.contains("R") && ( i1 == 6 || i1== 5 || i1== 4 || i1== 3) ){
	moveTarget(177,farbe);		
	}else{
	move(177,farbe);
	}
	break;
case R.id.button178:
	if(ButtonText.contains("R") && ( i1 == 5 || i1== 4 || i1== 3 || i1== 2) ){
	moveTarget(178,farbe);		
	}else{
	move(178,farbe);
	}
	break;
case R.id.button179:
	if(ButtonText.contains("R") && ( i1 == 4 || i1== 3 || i1== 2 || i1== 1) ){
	moveTarget(179,farbe);		
	}else{
	move(179,farbe);
	}
	break;
case R.id.button180:
	move(180,farbe);
	break;
case R.id.button181:
	move(181,farbe);
	break;
	
case R.id.button182:
	move(182,farbe);
	break;
	
case R.id.button183:
	move(183,farbe);
	break;
	
case R.id.button184:
	if(ButtonText.contains("Y") && i1 == 6 ){
		moveTarget(184,farbe);		
		}else{
	ButtonText = area[184].getText().toString();
	area[184].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[184].setText(" ");
	if (i1 == 6){
	area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[150].setText(ButtonText); break;
	}else{
	area[184 + i1].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
	}
	area[184 + i1].setText(ButtonText); break;
	}
case R.id.button185:
	if(ButtonText.contains("Y") && ( i1 == 6 || i1== 5) ){
		moveTarget(185,farbe);		
		}else{
	ButtonText = area[185].getText().toString();
	area[185].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[185].setText(" ");
	if (i1 == 5){
	area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[150].setText(ButtonText); break;
	}
	
	if (i1 == 6){
	area[151].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[151].setText(ButtonText); break;
	}else{
	area[185 + i1].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
	}
	
			   area[185 + i1].setText(ButtonText); break;
		}
case R.id.button186:
	if(ButtonText.contains("Y") && ( i1 == 6 || i1== 5 || i1== 4) ){
		moveTarget(186,farbe);		
		}else{
	ButtonText = area[186].getText().toString();
	area[186].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[186].setText(" ");
	if (i1 == 4){
		area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[150].setText(ButtonText); break;
	}
	
	if (i1 == 5){
		area[151].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[151].setText(ButtonText); break;
	}
	
	if (i1 == 6){
		area[152].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[152].setText(ButtonText); break;
	}else{
	area[186 + i1].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
	}
	
			   area[186 + i1].setText(ButtonText); break;
	}
case R.id.button187:
	if(ButtonText.contains("Y") && ( i1 == 6 || i1== 5 || i1== 4 || i1== 3) ){
		moveTarget(187,farbe);		
		}else{
	ButtonText = area[187].getText().toString();
	area[187].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[187].setText(" ");
	if (i1 == 3){
		area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[1501].setText(ButtonText); break;
	}
	
	if (i1 == 4){
		area[151].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[151].setText(ButtonText); break;
	}
	
	if (i1 == 5){
		area[152].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[152].setText(ButtonText); break;
	}
	
	if (i1 == 6){
		area[153].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[153].setText(ButtonText); break;
	}else{
	area[187 + i1].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
	}
	
			   area[187+ i1].setText(ButtonText); break;
	}
case R.id.button188:
	if(ButtonText.contains("Y") && ( i1 == 5 || i1== 4 || i1== 3 || i1== 2) ){
		moveTarget(188,farbe);		
		}else{
	ButtonText = area[188].getText().toString();
	area[188].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[188].setText(" ");
	if (i1 == 2){
		area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[150].setText(ButtonText); break;
	}
	
	if (i1 == 3){
		area[151].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[151].setText(ButtonText); break;
	}
	
	if (i1 == 4){
		area[152].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[152].setText(ButtonText); break;
	}
	
	if (i1 == 5){
		area[153].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
			   area[153].setText(ButtonText); break;
	}
	
	if (i1 == 6){
		area[154].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
			   area[154].setText(ButtonText); break;
	}else{
	area[188 + i1].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);	
	}
	
	area[188 + i1].setText(ButtonText); break;
		}	
case R.id.button189:
	if(ButtonText.contains("Y") && ( i1 == 4 || i1== 3 || i1== 2 || i1== 1) ){
		moveTarget(189,farbe);		
		}else{
	ButtonText = area[189].getText().toString();
	area[189].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[189].setText(" ");
	if (i1 == 1){
		area[150].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
		area[150].setText(ButtonText);
		}
	if (i1 == 2){
		area[151].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
	area[151].setText(ButtonText);
}
	if (i1 == 3){
		area[152].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
	area[152].setText(ButtonText);
		}
	if (i1 == 4){
		area[153].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
	area[153].setText(ButtonText);
}
	if (i1 == 5){
		area[154].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
	area[154].setText(ButtonText);
}
	if (i1 == 6){
		area[155].getBackground().setColorFilter(farbe, PorterDuff.Mode.MULTIPLY);
	area[155].setText(ButtonText);
}
	 break;	
		}
			}
			
		}

public void move(int field, int color){
	
	ButtonText = area[field].getText().toString();
	area[field].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[field].setText(" ");
	if (area[field + i1].getText().toString().equals(" ")){
	area[field + i1].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
	area[field + i1].setText(ButtonText); 
	}else{
		

		if(area[field+i1].getText().toString().contains("R")){
			if (area[field+i1].getText().toString().contains("1")){
				area[1].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
				area[1].setText("R1");
			}
			if (area[field+i1].getText().toString().contains("2")){
				area[2].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
				area[2].setText("R2");
			}
			if (area[field+i1].getText().toString().contains("3")){
				area[3].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
				area[3].setText("R3");
			}
			if (area[field+i1].getText().toString().contains("4")){
				area[4].getBackground().setColorFilter(0xFFFE2E2E, PorterDuff.Mode.MULTIPLY);
				area[4].setText("R4");
			}
		}
		
		if(area[field+i1].getText().toString().contains("Y")){
			if (area[field+i1].getText().toString().contains("1")){
				area[5].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
				area[5].setText("Y1");
			}
			if (area[field+i1].getText().toString().contains("2")){
				area[6].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
				area[6].setText("Y2");
			}
			if (area[field+i1].getText().toString().contains("3")){
				area[7].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
				area[7].setText("Y3");
			}
			if (area[field+i1].getText().toString().contains("4")){
				area[8].getBackground().setColorFilter(0xFFFFFF00, PorterDuff.Mode.MULTIPLY);
				area[8].setText("Y4");
			}
		}
		
		
		if(area[field+i1].getText().toString().contains("G")){
			if (area[field+i1].getText().toString().contains("1")){
				area[9].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
				area[9].setText("G1");
			}
			if (area[field+i1].getText().toString().contains("2")){
				area[10].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
				area[10].setText("G2");
			}
			if (area[field+i1].getText().toString().contains("3")){
				area[11].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
				area[11].setText("G3");
			}
			if (area[field+i1].getText().toString().contains("4")){
				area[12].getBackground().setColorFilter(0xFF008000, PorterDuff.Mode.MULTIPLY);
				area[12].setText("G4");
			}
		}
		
		if(area[field+i1].getText().toString().contains("B")){
			if (area[field+i1].getText().toString().contains("1")){
				area[13].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
				area[13].setText("B1");
			}
			if (area[field+i1].getText().toString().contains("2")){
				area[14].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
				area[14].setText("B2");
			}
			if (area[field+i1].getText().toString().contains("3")){
				area[15].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
				area[15].setText("B3");
			}
			if (area[field+i1].getText().toString().contains("4")){
				area[16].getBackground().setColorFilter(0xFF0000FF, PorterDuff.Mode.MULTIPLY);
				area[16].setText("B4");
			}
		}
		area[field+i1].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
		area[field+i1].setText(ButtonText); 
	}
}



public boolean checkplayer(int player){
	if(player == 1){
		if (area[1].getText().toString().contains("1") &&
			area[2].getText().toString().contains("2") && 
			area[3].getText().toString().contains("3") && 
			area[4].getText().toString().contains("4")){
			return true;
		}
	}

	if(player == 2){
		if (area[5].getText().toString().contains("1") &&
			area[6].getText().toString().contains("2") && 
			area[7].getText().toString().contains("3") && 
			area[8].getText().toString().contains("4")){
	return true;
		}
	}

	if(player == 3){
		if (area[9].getText().toString().contains("1") &&
			area[10].getText().toString().contains("2") && 
			area[11].getText().toString().contains("3") && 
			area[12].getText().toString().contains("4")){
		return true;
		}
	}
	if(player == 4){
		if (area[13].getText().toString().contains("1") &&
			area[14].getText().toString().contains("2") && 
			area[15].getText().toString().contains("3") && 
			area[16].getText().toString().contains("4")){
		return true;
		}
	}
	return false;
	
}

public void moveTarget(int field,int color){
	ButtonText = area[field].getText().toString();
	area[field].getBackground().setColorFilter(0xFFf5f5f5, PorterDuff.Mode.MULTIPLY);
	area[field].setText(" ");
	int k =0;
	int t =0;
	if( field == 174 ||field == 154 || field == 184 || field == 164){
		k=1;
		    if(ButtonText.contains("R")){
		    	t = Integer.parseInt(2 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.contains("Y")){
			t = Integer.parseInt(3 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.toString().contains("G")){
			t = Integer.parseInt(4 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.contains("B")){
			t = Integer.parseInt(5 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
	}	
		if( field == 175 ||field == 155 || field == 185 || field == 165){
			if (i1==6)k=2;
			if (i1==5)k=1;
			
		 if(ButtonText.contains("R")){
			t = Integer.parseInt(2 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.contains("Y")){
			t = Integer.parseInt(3 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.contains("G")){
			t = Integer.parseInt(4 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
		if(ButtonText.contains("B")){
			t = Integer.parseInt(5 +""+ k);
			if (area[t].getText().toString().equals(" ")){
			area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
			area[t].setText(ButtonText);
			}
		}
			
	}
	
		if( field == 176 ||field == 156 || field == 186 || field == 166){
			if (i1==6)k=3;
			if (i1==5)k=2;
			if (i1==4)k=1;
			
			 if(ButtonText.contains("R")){
					t = Integer.parseInt(2 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("Y")){
					t = Integer.parseInt(3 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("G")){
					t = Integer.parseInt(4 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("B")){
					t = Integer.parseInt(5 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
			
	}
		
		if( field == 177 ||field == 157 || field == 187 || field == 167){
			if (i1==6)k=4;
			if (i1==5)k=3;
			if (i1==4)k=2;
			if (i1==3)k=1;
			
			 if(ButtonText.contains("R")){
					t = Integer.parseInt(2 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("Y")){
					t = Integer.parseInt(3 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("G")){
					t = Integer.parseInt(4 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("B")){
					t = Integer.parseInt(5 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
			
	}
		
		if( field == 178 ||field == 158 || field == 188 || field == 168){
			if (i1==5)k=4;
			if (i1==4)k=3;
			if (i1==3)k=2;
			if (i1==2)k=1;
			
			 if(ButtonText.contains("R")){
					t = Integer.parseInt(2 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("Y")){
					t = Integer.parseInt(3 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("G")){
					t = Integer.parseInt(4 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("B")){
					t = Integer.parseInt(5 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
			
	}
		
		if( field == 179 ||field == 159 || field == 189 || field == 169){
			if (i1==4)k=4;
			if (i1==3)k=3;
			if (i1==2)k=2;
			if (i1==1)k=1;
			
			 if(ButtonText.contains("R")){
					t = Integer.parseInt(2 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("Y")){
					t = Integer.parseInt(3 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("G")){
					t = Integer.parseInt(4 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
				if(ButtonText.contains("B")){
					t = Integer.parseInt(5 +""+ k);
					if (area[t].getText().toString().equals(" ")){
					area[t].getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
					area[t].setText(ButtonText);
					}
				}
			
	}


	}
	



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}