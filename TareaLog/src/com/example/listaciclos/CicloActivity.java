package com.example.listaciclos;

import java.util.ArrayList;

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

public class CicloActivity extends Activity {
	private ListView listEscuelas;
	final ArrayList<String> nombr= new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ciclos);
		final EditText input_name = (EditText) findViewById(R.id.txt_buscar);

		listEscuelas = (ListView) findViewById(R.id.lv_ciclos);
		CicloSQLiteHelper uDBd = new CicloSQLiteHelper(
				getApplicationContext(), "DBUg", null, 41);
		SQLiteDatabase db = uDBd.getWritableDatabase();

			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('1','2012-1','2600','2200','200','200')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('2','2012-2','2700','2000','600','100')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('3','2013-1','2805','2500','200','105')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('4','2013-2','3000','2800','150','50')");
			db.execSQL("INSERT INTO Escuela (idesc, namesc, cantesc, alumnosmatriculadosvirtualesc, alumnosmatriculadospresencialesc, alumnosnomatriculadosesc) VALUES('5','2014-1','2700','2500','180','30')");

			db.close();

			Button btn_submit = (Button) findViewById(R.id.btn_buscar);

			btn_submit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					CicloSQLiteHelper uDBd = new CicloSQLiteHelper(
							getApplicationContext(), "DBUg", null, 41);

					ArrayList<Ciclo> lista = new ArrayList<Ciclo>();

					SQLiteDatabase dbSelecttt = uDBd.getReadableDatabase();
					String name = input_name.getText().toString();
					Cursor cursor = dbSelecttt.rawQuery("SELECT * FROM Escuela where namesc='"+name+"'",null);
					if (!cursor.moveToNext()){
						Toast.makeText(getApplicationContext(), "No Hay Ciclo :"+name,Toast.LENGTH_LONG).show();
							
					}else{

						while (cursor.moveToNext()) {
							Ciclo p = new Ciclo();
							p.setNamesc(cursor.getString(1));
							p.setCantesc(cursor.getString(2));
							p.setAlumnosmatriculadospresencialesc(cursor.getString(3));
							p.setAlumnosmatriculadosvirtualesc(cursor.getString(4));
						//	p.setAlumnosnomatriculadosesc(cursor.getString(5));

							lista.add(p);
						}

						cursor.close();
						dbSelecttt.close();

						listEscuelas.setAdapter(new CicloAdapter(getApplicationContext(),
								R.layout.row_ciclos, lista));
					}
				}});

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
