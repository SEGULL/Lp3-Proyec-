package com.example.listafacultades;

import java.util.ArrayList;

import com.example.listaescuelas.EscuelaActivity;
import com.example.sql.UsuarioSQLiteHelper;
import com.example.tarealog.Bloq;
import com.example.tarealog.Log;
import com.example.tarealog.R;
import com.example.tarealog.WelcomeUser;

//import com.example.tarealog.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class FacultadActivity extends Activity {
	private ListView listEscuelas;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facultad);
		final EditText input_facultad = (EditText) findViewById(R.id.txt_facultad);
		final EditText input_ciclo = (EditText) findViewById(R.id.txt_ciclo);

		listEscuelas = (ListView) findViewById(R.id.lv_facultades);
		FacultadSQLiteHelper uDDB = new FacultadSQLiteHelper(
		getApplicationContext(), "DBUu", null, 41);
		SQLiteDatabase db = uDDB.getWritableDatabase();

			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Ingenieria y Arquitectura','1150','1080','40','2012-1')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('2','Saludddd','650','580','40','2012-2')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('3','Empresariales','800','730','40','2013-1')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('4','Educacion','100','80','20','2013-2')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('5','Teologia','150','80','40','2014-1')");

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
	
		
		Button btn_facul = (Button) findViewById(R.id.btn_buscarfacultad);

		btn_facul.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
		
	String faculta = input_facultad.getText().toString();
	String ciclo = input_ciclo.getText().toString();
	
		if(faculta.equals("")&&ciclo.equals("")){
			Toast.makeText(getApplicationContext(), "No Ingreso Datos",Toast.LENGTH_LONG).show();
		}else{
			if(ciclo.equals("")&&faculta.equals(faculta)){
				ArrayList<Facultad> lista = new ArrayList<Facultad>();
				FacultadSQLiteHelper uD = new FacultadSQLiteHelper(
						getApplicationContext(), "DBUu", null, 41);
								SQLiteDatabase dbSelectt = uD.getReadableDatabase();
				Cursor cursor = dbSelectt.rawQuery(
						"SELECT * FROM Escuela where namesc='"+faculta+"' ",
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
			}else{
				if(faculta.equals("")&&ciclo.equals(ciclo)){
					ArrayList<Facultad> lista = new ArrayList<Facultad>();
					FacultadSQLiteHelper uD = new FacultadSQLiteHelper(
							getApplicationContext(), "DBUu", null, 41);
									SQLiteDatabase dbSelectt = uD.getReadableDatabase();
					Cursor cursor = dbSelectt.rawQuery(
							"SELECT * FROM Escuela where alumnosnomatriculadosesc='"+ciclo+"' ",
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
				}else{
					if(faculta.equals(faculta)&&ciclo.equals(ciclo)){
						ArrayList<Facultad> lista = new ArrayList<Facultad>();
						FacultadSQLiteHelper uD = new FacultadSQLiteHelper(
								getApplicationContext(), "DBUu", null, 41);
										SQLiteDatabase dbSelectt = uD.getReadableDatabase();
						Cursor cursor = dbSelectt.rawQuery(
								"SELECT * FROM Escuela where namesc='"+faculta+"' and alumnosnomatriculadosesc='"+ciclo+"' ",
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
				}
			}
		}
			
				
				
			}
		});

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
			try {
				UsuarioSQLiteHelper uDB = new UsuarioSQLiteHelper(
						getApplicationContext(), "DBUsuarios", null, 41);
				SQLiteDatabase db = uDB.getWritableDatabase();
				ContentValues valores = new ContentValues();
				valores.put("act","0");
				db.update("Usuario", valores, "act=1", null);
				Toast.makeText(getApplicationContext(), "Cerrando Seccion",Toast.LENGTH_LONG).show();
				Intent esttt = new Intent(getApplicationContext(),Log.class);
				startActivity(esttt);
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(getApplicationContext(), "No Cierra Seccion"+e.getMessage(),Toast.LENGTH_LONG).show();
			}
			return true;
		default:
			Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
			return true;
		}}}
