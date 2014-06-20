package com.example.proyec1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Log extends Activity {
	private static final ArrayList<String> names = new ArrayList<String>();
	private static final ArrayList<String> pass = new ArrayList<String>();
	private static final String NAME_TAG ="name";
	private TextView txt_name;
	private TextView txt_pass;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		
		final EditText input_name = (EditText) findViewById(R.id.txt_userrr);

		final EditText input_pas = (EditText) findViewById(R.id.txt_passs);
		Button btn_submit = (Button) findViewById(R.id.btn_ingresar);
		btn_submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					SQLPersonaSQLiteHelper udb= new SQLPersonaSQLiteHelper(getApplicationContext(), "dbusuario", null, 2);
					SQLiteDatabase db=udb.getWritableDatabase();
					String name = input_name.getText().toString();
					String password = input_pas.getText().toString();
					if(name.equals("segundo")&&password.equals("123")){////ingreso como alumno

						Intent intent1 = new Intent(getApplicationContext(),Inicio.class);
								startActivity(intent1);				
					}
					else{if(name.equals("neal")&&password.equals("123")){//////ingreso como administrador
						
						Intent intent1 = new Intent(getApplicationContext(),ViewAdm.class);
						startActivity(intent1);				
			
					}
					}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log, menu);
		return true;
	}

}
