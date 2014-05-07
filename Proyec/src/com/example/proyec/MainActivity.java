package com.example.proyec;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	public void validarIngreso(View view) {

		EditText usuario = (EditText) findViewById(R.id.txtUsuario);
		EditText passw = (EditText) findViewById(R.id.txtPasswd);

		
		if (usuario.equals("segundo") && passw.equals("123")) {
			Intent intent = new Intent(getApplicationContext(), MainActivity1.class);		
			startActivity(intent);
		} else {
			
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);

					intent.putExtra("no tines acceso", usuario.getText().toString());

					stopService(intent);
					
				}
				
				
			}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
