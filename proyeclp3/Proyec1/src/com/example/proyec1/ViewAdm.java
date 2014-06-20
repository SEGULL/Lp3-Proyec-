package com.example.proyec1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewAdm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_adm);

		Button btn_escuela = (Button) findViewById(R.id.btn_escuela);
		btn_escuela.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
						Intent esc = new Intent(getApplicationContext(),ViewEscuelas.class);
						startActivity(esc);				
			}
			
		});
		
		Button btn_facultad = (Button) findViewById(R.id.btn_facultad);
		btn_facultad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
						Intent fa = new Intent(getApplicationContext(),ViewFacultades.class);
						startActivity(fa);				
			}
			
		});

		Button btn_estadistica = (Button) findViewById(R.id.btn_estadisticas);
		btn_estadistica.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
						Intent es = new Intent(getApplicationContext(),ViewEstadisticas.class);
						startActivity(es);				
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_adm, menu);
		return true;
	}

}
