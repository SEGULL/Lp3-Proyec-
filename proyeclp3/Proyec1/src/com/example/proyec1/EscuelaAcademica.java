package com.example.proyec1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EscuelaAcademica extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escuela_academica);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.escuela_academica, menu);
		return true;
	}

}
