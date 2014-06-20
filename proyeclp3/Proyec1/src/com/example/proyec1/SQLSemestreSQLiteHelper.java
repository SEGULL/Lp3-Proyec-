package com.example.proyec1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLSemestreSQLiteHelper  extends SQLiteOpenHelper{

	private String sqlCreate= "CREATE TABLE ModSemestre (idsemester TEXT, nombre_semestre TEXT,fecha_inicio TEXT" +
			",fecha_inicio TEXT,fecha_final TEXT,numero_creditos TEXT,nombre_tutor TEXT)";

	public SQLSemestreSQLiteHelper(Context context, String name,
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
		db.execSQL("DROP TABLE IF EXISTs ModSemestre");
		db.execSQL(sqlCreate);
		
	}

	
	}
 