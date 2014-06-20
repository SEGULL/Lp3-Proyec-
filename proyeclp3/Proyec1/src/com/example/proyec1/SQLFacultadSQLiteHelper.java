package com.example.proyec1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLFacultadSQLiteHelper extends SQLiteOpenHelper {

	private String sqlCreate= "CREATE TABLE ModFacultad (idfacultad TEXT, nombrefacultad TEXT" +
			",cantidadalumnosfac TEXT,alumnosmatriculadosvirtualfac TEXT,alumnosmatriculadospresencialfac TEXT,alumnosnomatriculadosfac TEXT)";


	
	/*
	 * 	private int idescuela;
	private String nombrefacultad;
	private int cantidadalumnosfac;
	private int alumnosmatriculadosvirtualfac;
	private int alumnosmatriculadospresencialfac;
  	private int alumnosnomatriculadosfac;

	 * */
	public SQLFacultadSQLiteHelper(Context context, String name,
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
		db.execSQL("DROP TABLE IF EXISTs ModFacultad");
		db.execSQL(sqlCreate);	
	}}
