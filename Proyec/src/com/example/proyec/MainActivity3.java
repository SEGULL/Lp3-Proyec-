package com.example.proyec;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
	}
	public void ingresofacultad(View view) {		
		Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
		startActivity(intent);
		}
	
	public void ingresociclo(View view) {		
		Intent intent = new Intent(getApplicationContext(), FullscreenActivity0.class);
		startActivity(intent);
		}
	
	public void ingresoescuela(View view) {		
		Intent intent = new Intent(getApplicationContext(), MainActivity5.class);
		startActivity(intent);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
		return true;
	}

}
