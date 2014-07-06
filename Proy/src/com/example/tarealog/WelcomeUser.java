package com.example.tarealog;
import com.example.listaescuelas.EscuelaActivity;
import com.example.listafacultades.FacultadActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
public class WelcomeUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_user);

		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_user, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_escuela:
			try {
				Intent it = new Intent(getApplicationContext(),EscuelaActivity.class );
				startActivity(it);
} catch (Exception e) {
	// TODO: handle exception
	Toast.makeText(getApplicationContext(), "..."+e.getMessage(),Toast.LENGTH_LONG).show();
}
			return true;
		case R.id.action_facultad:
			try {
				Intent itt = new Intent(getApplicationContext(),FacultadActivity.class );
				startActivity(itt);
					
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), ""+e.getMessage(),Toast.LENGTH_LONG).show();
			}
			
			return true;
		case R.id.action_estadistica:
			try {
				Intent est = new Intent(getApplicationContext(),EstadisticosGenerales.class);
				startActivity(est);
					
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), ""+e.getMessage(),Toast.LENGTH_LONG).show();
			}
			return true;
		case R.id.action_cerrar:
			try {
					
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), ""+e.getMessage(),Toast.LENGTH_LONG).show();
			}
			return true;
		default:
			Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
			return true;
		}}}
