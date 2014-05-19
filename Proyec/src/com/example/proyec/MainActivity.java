package com.example.proyec;

import java.io.Closeable;
import java.nio.channels.ClosedByInterruptException;

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
		
//		switch (usuario && passw) {
//		
//		case "segundo"&& :
//			Intent intent = new Intent(getApplicationContext(), MainActivity1.class);		
//			startActivity(intent);
//			
//			break;
//
//		default:
//			break;
//		}
		if (usuario.equals("segundo") && passw.equals("123")) {
			Intent intent = new Intent(getApplicationContext(), MainActivity1.class);		
			startActivity(intent);
		} else { if (usuario.equals("neal") && passw.equals("123")) {
			Intent intenttt = new Intent(getApplicationContext(), MainActivity3.class);
		    startActivity(intenttt);			
		       }			
		    Intent intentt = new Intent(getApplicationContext(), FullscreenActivity0.class);
		    startActivity(intentt);
		}
	
	}		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
