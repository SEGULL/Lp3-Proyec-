package com.example.listaescuelas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class EscuelaSQLiteHelper extends SQLiteOpenHelper {

	private String sqlCreate = "CREATE TABLE Escuela (idesc TEXT, namesc TEXT, cantesc TEXT, alumnosmatriculadosvirtualesc TEXT, alumnosmatriculadospresencialesc TEXT, alumnosnomatriculadosesc TEXT)";
  	
	public EscuelaSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Escuela");
		db.execSQL(sqlCreate);
	}

}
