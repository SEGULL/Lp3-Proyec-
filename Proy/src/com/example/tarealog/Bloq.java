package com.example.tarealog;

import com.example.sql.UsuarioSQLiteHelper;
import com.example.tarealog.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Bloq extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloq);
		
	}
	public void validaringreso(View view) {
		
		Intent intent = new Intent(getApplicationContext(), Log.class);		
		startActivity(intent);
		UsuarioSQLiteHelper uDB=new UsuarioSQLiteHelper(getApplicationContext(), "DBUsuarios", null, 39);//instancia de la DB
		SQLiteDatabase db=uDB.getWritableDatabase();
		db.execSQL("INSERT INTO Usuario(User,password,act)VALUES('canahuire','456','0')");
		db.execSQL("INSERT INTO Usuario(User,password,act)VALUES('neal','123','0')");
		db.close();
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bloq, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.Cerrar:
			Toast.makeText(this, "Cerrar", Toast.LENGTH_SHORT).show();
			//Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
			finishActivity(TRIM_MEMORY_COMPLETE);
			return true;
		case R.id.Iniciar:
			Toast.makeText(this, "Iniciar", Toast.LENGTH_SHORT).show();
			Intent inte = new Intent(getApplicationContext(),Log.class);
			startActivity(inte);
			return true;
		default:
			Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
			return true;
		}}}