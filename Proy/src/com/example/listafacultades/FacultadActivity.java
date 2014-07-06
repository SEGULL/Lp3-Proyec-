package com.example.listafacultades;

import java.util.ArrayList;

import com.example.tarealog.R;

//import com.example.tarealog.R;


import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.ListView;

public class FacultadActivity extends Activity {
	private ListView listEscuelas;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facultad);
		listEscuelas = (ListView) findViewById(R.id.lv_facultades);
		FacultadSQLiteHelper uDDB = new FacultadSQLiteHelper(
		getApplicationContext(), "DBUu", null, 39);
		SQLiteDatabase db = uDDB.getWritableDatabase();

			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Ingenieria y Arquitectura','150','80','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('2','Saludddd','180','110','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('3','Empresariales','140','70','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('4','Educacion','100','80','20','0')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('5','Teologia','150','80','40','30')");

			db.close();

		ArrayList<Facultad> lista = new ArrayList<Facultad>();

		SQLiteDatabase dbSelectt = uDDB.getReadableDatabase();

		Cursor cursor = dbSelectt.rawQuery(
				"SELECT * FROM Escuela",
				null);

		while (cursor.moveToNext()) {
			Facultad p = new Facultad();
			p.setNamesc(cursor.getString(1));
			p.setCantesc(cursor.getString(2));
			p.setAlumnosmatriculadospresencialesc(cursor.getString(3));
			p.setAlumnosmatriculadosvirtualesc(cursor.getString(4));
			p.setAlumnosnomatriculadosesc(cursor.getString(5));

			lista.add(p);
		}

		cursor.close();
		dbSelectt.close();

		listEscuelas.setAdapter(new FacultadAdapter(getApplicationContext(),
				R.layout.row_facultad, lista));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.escuela, menu);
		return true;
	}

}
