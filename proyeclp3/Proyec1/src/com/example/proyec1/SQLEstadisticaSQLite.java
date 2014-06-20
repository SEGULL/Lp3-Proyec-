package com.example.proyec1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLEstadisticaSQLite  extends SQLiteOpenHelper {

	private String sqlCreate= "CREATE TABLE ModEstadisticosGenerales (idestadistica TEXT, año TEXT" +
			",cantidadmatriculadosvirtualmente TEXT,cantidadmatriculadospresencial TEXT,cantidadalumnosnomatriculados TEXT)";
	public SQLEstadisticaSQLite(Context context, String name,
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
