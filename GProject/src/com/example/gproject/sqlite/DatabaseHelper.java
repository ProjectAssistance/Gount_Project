package com.example.gproject.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "myDB";
	private static final int DATABASE_VERSION = 1;
	
	public static final String PROFILE_TABLE = "Profile";
    public static final String COL_NAME = "Name";
    public static final String COL_SURNAME = "Surname";
    public static final String COL_DISEASE = "Disease";
    public static final String COL_URIVALUE = "UricValue";
    public static final String COL_ALLERGIC = "Allergic";
    
	private static final String DATABASE_CREATE = "create table" + PROFILE_TABLE
			+ "( _id integer primary key,"
			+ COL_NAME + " TEXT, " 
			+ COL_SURNAME + "TEXT, " 
			+ COL_DISEASE + "TEXT, "
			+ COL_URIVALUE + "TEXT, "
			+ COL_ALLERGIC + "TEXT);";
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(), 
				"Upgrade database version from version" + oldVersion + " to " 
				+ newVersion + "which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
		onCreate(db);
		
	}
    
}
