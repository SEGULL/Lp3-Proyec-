package com.example.proyec1;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Bloq<PersonaSQLiteHelper> extends Activity {
	private boolean esFavorito = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn_submit = (Button) findViewById(R.id.btn_ingre);
		btn_submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
						Intent intent1 = new Intent(getApplicationContext(),Log.class);
						startActivity(intent1);				
			}
			
		});
		
/////////////////////////////////////////////////////////////////////////////////////////		
		
//		SQLPersonaSQLiteHelper uDB = new SQLPersonaSQLiteHelper(
//				getApplicationContext(), "DBUPeU", null, 2);
//
//		SQLiteDatabase db = uDB.getWritableDatabase();
//
//		for (int i = 1; i <= 15; i++) {
//
//			int id = i;
//			String nombre = "Nombre " + i;
//			String apepat = "Paterno " + i;
//			String apemat = "Materno " + i;
//			String direccion = "Direccion " + i;
//			String celular = "Celular " + i;
//
//			db.execSQL("INSERT INTO Persona (id,nombre, apepat,apemat,direccion,celular) VALUES("
//					+ id
//					+ ",'"
//					+ nombre
//					+ "','"
//					+ apepat
//					+ "','"
//					+ apemat
//					+ "','" + direccion + "','" + celular + "')");
//
//		}
//		db.close();
//
//		
//		
//		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {


		switch (item.getItemId()) {
		case R.id.action_share:
			Intent intent = new Intent(getApplicationContext(),Log.class);
			startActivity(intent);				

			return true;

		default:
			Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
			return true;
		}

	}


}
