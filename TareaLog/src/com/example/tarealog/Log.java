package com.example.tarealog;

import java.util.ArrayList;

import com.example.sql.UsuarioSQLiteHelper;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Log extends Activity {

	private static final ArrayList<String> names = new ArrayList<String>();
	private static final ArrayList<String> passs = new ArrayList<String>();
	public static final String NAME_TAG = "name";
	private TextView txt_name;
	private TextView txt_pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);

		final EditText input_name = (EditText) findViewById(R.id.txt_usuario);
		final EditText input_pass = (EditText) findViewById(R.id.txt_password);
		Button btn_submit = (Button) findViewById(R.id.btn_ingresar);

		btn_submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				UsuarioSQLiteHelper uDB = new UsuarioSQLiteHelper(
						getApplicationContext(), "DBUsuarios", null, 41);
				SQLiteDatabase db = uDB.getWritableDatabase();

				String name = input_name.getText().toString();
				String pas = input_pass.getText().toString();

				Cursor cursor = db.rawQuery(
						"SELECT  User FROM Usuario where User='" + name
								+ "' and password = '" + pas + "'", null);
				if (cursor.moveToNext()) {
					Toast.makeText(getApplicationContext(), "Bienvenido :"+name,Toast.LENGTH_LONG).show();
					try {

						UsuarioSQLiteHelper iDB=new UsuarioSQLiteHelper(getApplicationContext(), "DBUsuarios", null, 41);//instancia de la DB
						SQLiteDatabase dbb=iDB.getWritableDatabase();
						ContentValues valores = new ContentValues();
						valores.put("act","1");
						db.update("Usuario", valores, "act=0", null);
						Toast.makeText(getApplicationContext(), "actualizo",Toast.LENGTH_LONG).show();
							
					} catch (Exception e) {
						// TODO: handle exception
						Toast.makeText(getApplicationContext(), "no actualizo",Toast.LENGTH_LONG).show();
						}
					Intent intent = new Intent(getApplicationContext(),WelcomeUser.class);
					startActivity(intent);

					
				} else {
					Toast.makeText(getApplicationContext(), "Error Al Iniciar Seccion :"+name,Toast.LENGTH_LONG).show();
					Intent intentt = new Intent(getApplicationContext(),Bloq.class);
					startActivity(intentt);
				}
				cursor.close();
				db.close();

			}
		});

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_new_user, menu);
		return true;
	}

	class MiListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "..... :)",
					Toast.LENGTH_LONG).show();
		}
	}
}
