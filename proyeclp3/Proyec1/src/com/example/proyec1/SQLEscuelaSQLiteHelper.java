package com.example.proyec1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLEscuelaSQLiteHelper extends SQLiteOpenHelper {

	private String sqlCreate= "CREATE TABLE ModEscuela (idescuela TEXT, Nombre_Escuela TEXT" +
			",Cantidad_Alumnos TEXT,alumnosmatriculadosvirtual TEXT,alumnosmatriculadospresencial TEXT,alumnosnomatriculados TEXT)";


	public SQLEscuelaSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sqlCreate);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTs ModEscuela");
		db.execSQL(sqlCreate);	
	}}
