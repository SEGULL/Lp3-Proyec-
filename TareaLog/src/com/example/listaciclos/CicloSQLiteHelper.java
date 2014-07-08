package com.example.listaciclos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CicloSQLiteHelper extends SQLiteOpenHelper {

	private String sqlCreatee = "CREATE TABLE Escuela (idesc TEXT, namesc TEXT, cantesc TEXT, alumnosmatriculadosvirtualesc TEXT, alumnosmatriculadospresencialesc TEXT, alumnosnomatriculadosesc TEXT)";
  	
	public CicloSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreatee);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Escuela");
		db.execSQL(sqlCreatee);
	}

}
