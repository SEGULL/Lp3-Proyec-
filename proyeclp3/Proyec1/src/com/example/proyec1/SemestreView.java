package com.example.proyec1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SemestreView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_semestre_view);

		Button btn_sumi = (Button) findViewById(R.id.btn_regres);
		btn_sumi.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
						Intent es = new Intent(getApplicationContext(),Inicio.class);
						startActivity(es);				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.semestre_view, menu);
		return true;
	}

}
