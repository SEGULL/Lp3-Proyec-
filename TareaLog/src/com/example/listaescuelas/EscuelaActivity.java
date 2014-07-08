package com.example.listaescuelas;

import java.util.ArrayList;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

import com.example.sql.UsuarioSQLiteHelper;
import com.example.tarealog.Log;
import com.example.tarealog.R;


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

public class EscuelaActivity extends Activity {
	private ListView listEscuelas;
	private PullToRefreshLayout pull_to_refresh_layout;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escuela);
		final EditText input_ciclo = (EditText) findViewById(R.id.txt_cicloes);
		final EditText input_escuela = (EditText) findViewById(R.id.txt_escuela);
	
		
		listEscuelas = (ListView) findViewById(R.id.lv_escuela);
		pull_to_refresh_layout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
		ActionBarPullToRefresh.from(this).allChildrenArePullable()
		.listener(new OnRefreshListener() {
			@Override
			public void onRefreshStarted(View view) {
				ArrayList<Escuela> lista = new ArrayList<Escuela>();

				EscuelaSQLiteHelper uDBf = new EscuelaSQLiteHelper(
						getApplicationContext(), "DBU", null, 41);

				SQLiteDatabase dbSelect = uDBf.getReadableDatabase();

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
		
			}
});


		EscuelaSQLiteHelper uDB = new EscuelaSQLiteHelper(
				getApplicationContext(), "DBU", null, 41);
		SQLiteDatabase db = uDB.getWritableDatabase();

			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','Civil','500','730','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('2','Salud','150','80','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('3','Spicologia','500','420','50','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('4','Sistemas','150','80','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('5','Contabilidad','500','430','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('6','Administracion','300','230','40','30')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('7','Educacion','100','30','40','30')");
			db.close();

		ArrayList<Escuela> lista = new ArrayList<Escuela>();
		EscuelaSQLiteHelper uDBf = new EscuelaSQLiteHelper(
				getApplicationContext(), "DBU", null, 41);

		SQLiteDatabase dbSelect = uDBf.getReadableDatabase();

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
		
		Button btn_escuela = (Button) findViewById(R.id.btn_especificoescuela);

		btn_escuela.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String escuela = input_escuela.getText().toString();
				String ciclo = input_ciclo.getText().toString();
				if(ciclo.equals("")&&escuela.equals("")){
					Toast.makeText(getApplicationContext(), "No Ingreso Datos",Toast.LENGTH_LONG).show();
				}else{
					if(ciclo.equals("")&&escuela.equals(escuela)){

						ArrayList<Escuela> lista = new ArrayList<Escuela>();
						EscuelaSQLiteHelper uDBf = new EscuelaSQLiteHelper(
								getApplicationContext(), "DBU", null, 41);

						SQLiteDatabase dbSelect = uDBf.getReadableDatabase();

						Cursor cursor = dbSelect.rawQuery(
								"SELECT * FROM Escuela where namesc='"+escuela+"'",
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
					else{
						if(escuela.equals("")&&ciclo.equals(ciclo)){

							ArrayList<Escuela> lista = new ArrayList<Escuela>();
							EscuelaSQLiteHelper uDBf = new EscuelaSQLiteHelper(
									getApplicationContext(), "DBU", null, 41);

							SQLiteDatabase dbSelect = uDBf.getReadableDatabase();

							Cursor cursor = dbSelect.rawQuery(
									"SELECT * FROM Escuela where alumnosnomatriculadosesc='"+ciclo+"'",
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
							
						}else{
							if(escuela.equals(escuela)&&ciclo.equals(ciclo)){}
							
							ArrayList<Escuela> lista = new ArrayList<Escuela>();
							EscuelaSQLiteHelper uDBf = new EscuelaSQLiteHelper(
									getApplicationContext(), "DBU", null, 41);

							SQLiteDatabase dbSelect = uDBf.getReadableDatabase();

							Cursor cursor = dbSelect.rawQuery(
									"SELECT * FROM Escuela where namesc='"+escuela+"' and alumnosnomatriculadosesc='"+ciclo+"'",
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
