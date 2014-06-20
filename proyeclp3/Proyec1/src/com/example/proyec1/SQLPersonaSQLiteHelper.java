package com.example.proyec1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLPersonaSQLiteHelper  extends SQLiteOpenHelper{

	private String sqlCreate= "CREATE TABLE ModPersona (id TEXT, user TEXT" +
			",password TEXT,Cargo TEXT,nombre TEXT,apepat TEXT,apemat TEXT,Dni TEXT" +
			",direccion TEXT,act TEXT,situacionFinanciera TEXT)";

	
	public SQLPersonaSQLiteHelper(Context context, String name,
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
		db.execSQL("DROP TABLE IF EXISTs ModPersona");
		db.execSQL(sqlCreate);	
		
	}
	
}
