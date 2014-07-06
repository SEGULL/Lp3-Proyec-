package com.example.listaescuelas;

import java.util.ArrayList;

import com.example.tarealog.Log;
import com.example.tarealog.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EscuelaActivity extends Activity {
	private ListView listEscuelas;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escuela);
		listEscuelas = (ListView) findViewById(R.id.lv_escuela);
		EscuelaSQLiteHelper uDB = new EscuelaSQLiteHelper(
				getApplicationContext(), "DBU", null, 39);
		SQLiteDatabase db = uDB.getWritableDatabase();

			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Civil','150','80','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Salud','200','130','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Spicologia','150','70','50','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Sistemas','150','80','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Contabilidad','160','90','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Administracion','120','50','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Educacion','100','30','40','30')");
//			db.execSQL("INSERT INTO Escuela (idesc,namesc, cantesc,alumnosmatriculadosvirtualesc,alumnosmatriculadospresencialesc,alumnosnomatriculadosesc) VALUES('2','Civil','200','130','40','30')");
//			db.execSQL("INSERT INTO Escuela (idesc,namesc, cantesc,alumnosmatriculadosvirtualesc,alumnosmatriculadospresencialesc,alumnosnomatriculadosesc) VALUES('3','Civil','250','180','40','30')");
//			db.execSQL("INSERT INTO Escuela (idesc,namesc, cantesc,alumnosmatriculadosvirtualesc,alumnosmatriculadospresencialesc,alumnosnomatriculadosesc) VALUES('4','Civil','100','30','40','30')");
			db.close();

		ArrayList<Escuela> lista = new ArrayList<Escuela>();

		SQLiteDatabase dbSelect = uDB.getReadableDatabase();

		Cursor cursor = dbSelect.rawQuery(
				"SELECT * FROM Escuela",
				null);

		while (cursor.moveToNext()) {
			Escuela p = new Escuela();
			p.setNamesc(cursor.getString(1));
			p.setCantesc(cursor.getString(2));
			p.setAlumnosmatriculadospresencialesc(cursor.getString(3));
			p.setAlumnosmatriculadosvirtualesc(cursor.getString(4));
			p.setAlumnosnomatriculadosesc(cursor.getString(5));
			

			lista.add(p);
		}

		cursor.close();
		dbSelect.close();

		listEscuelas.setAdapter(new EscuelaAdapter(getApplicationContext(),
				R.layout.row_escuela, lista));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.escuela, menu);
		return true;
	}
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case R.id.Cerrar:
				Toast.makeText(this, "cerrar", Toast.LENGTH_SHORT).show();
				//Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
				return true;
			default:
				Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
				return true;
			}}}
