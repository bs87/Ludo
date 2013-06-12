package com.example.ludoapp;

import com.example.ludoWebservice.ILudoWebservice;
import com.example.ludoWebservice.LudoWebserviceStub;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends Activity {

private Button zurueck;
private Button register;
registryTask registrytask;
ILudoWebservice service; 
private String Username, Passwort;
private EditText UsernameEditText;
private EditText PasswortEditText1;
private EditText PasswortEditText2;
private View mLoginFormView;
private View mLoginStatusView;
private TextView mLoginStatusMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		// AsyncTasks zur Registrierung
		
		service = new LudoWebserviceStub();
		registrytask = new registryTask();
		UsernameEditText = (EditText) findViewById(R.id.editTextBenutzername);		
		PasswortEditText1 = (EditText) findViewById(R.id.editTextPasswort1);
		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);
		zurueck = (Button) findViewById(R.id.buttonZurueck2);
		
		zurueck.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent nextScreen = new Intent(getApplicationContext(), Startscreen.class);	
					startActivity(nextScreen);
				}
			});	
		
		register = (Button) findViewById(R.id.buttonReg);
		
		register.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					
					Username = UsernameEditText.getText().toString();
					Passwort = PasswortEditText1.getText().toString();
					if (Username.length() != 0  & Passwort.length() != 0){
					//showProgress(true);
					registrytask.execute();
					}else{
				    showToast("Username und Passwort müssen ausgefüllt sein");
						
					}
					
				}
			});	
		
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	class registryTask extends AsyncTask<String, Integer, String>{

		@Override
		protected void onPostExecute(String result) {
		
			//showProgress(false);
			Intent nextScreen = new Intent(getApplicationContext(), Userscreen.class);	
			startActivity(nextScreen);
			
		}

		@Override
		protected String doInBackground(String... params) {
			String result = service.getLoginDaten(Username,Passwort);
			
			return result.toString();
			}
			
	}
	
	void showToast(CharSequence msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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
	
	
}
