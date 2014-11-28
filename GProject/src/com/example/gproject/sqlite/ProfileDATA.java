package com.example.gproject.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProfileDATA {
	
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	private Context context;
	
	private static final String PROFILE_TABLE = "Profile";
	private static final String COL_ID = "_id";
	private static final String COL_NAME = "Name";
	private static final String COL_SURNAME = "Surname";
	private static final String COL_DISEASE = "Disease";
	private static final String COL_URIVALUE = "UricValue";
	private static final String COL_ALLERGIC = "Allergic";
	
	
	public ProfileDATA() {
		// TODO Auto-generated constructor stub
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();

	}
	
	public long addProfile(String Name, String Surname, String Disease, String UricValue, 
			String Allergic) {
		ContentValues values = new ContentValues();
		values.put(COL_NAME, Name);
		values.put(COL_SURNAME, Surname);
		values.put(COL_DISEASE, Disease);
		values.put(COL_URIVALUE, UricValue);
		values.put(COL_ALLERGIC, Allergic);
		
		return database.insert(PROFILE_TABLE, null, values);
	}

	public Cursor readAllStudent() {
		Cursor mCursor = database.query(true, PROFILE_TABLE, new String[] {
				COL_ID, COL_NAME, COL_SURNAME, COL_DISEASE, COL_URIVALUE, COL_URIVALUE }, null, null, null, null, null, null);
		if(mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int updateStudent(String id, String Name, String Surname, String Disease, 
			String UricValue, String Allergic) {
		ContentValues values = new ContentValues();
		values.put(COL_ID, id);
		values.put(COL_NAME, Name);
		values.put(COL_SURNAME, Surname);
		values.put(COL_DISEASE, Disease);
		values.put(COL_URIVALUE, UricValue);
		values.put(COL_ALLERGIC, Allergic);
		return database.update(PROFILE_TABLE, values, COL_ID + "=?", new String[] { id });
	}
	
	public boolean deleteStudent(String id) {
		return database.delete(PROFILE_TABLE, COL_ID + "=" + id, null) > 0;
	}
	
}
