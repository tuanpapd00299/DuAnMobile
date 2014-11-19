package tuan.Database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import tuan.Obj.ItemsList;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlLiteDbHelper extends SQLiteOpenHelper {
	
	public static String DB_PATH = "/data/data/com.example.tiengnhat/databases/";
	public static String DB_NAME = "testdb.sqlite";
	public static final int DB_VERSION = 5;
	private static final String TABLE_NAME = "phrase";
//	public static final String TB_USER = "Users";
	
	private SQLiteDatabase myDB;
	private Context context;
	
	public SqlLiteDbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);	
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public synchronized void close(){
		if(myDB!=null){
			myDB.close();
		}
		super.close();
	}
	public ArrayList<ItemsList> getTimkiem() {
		ArrayList<ItemsList> listLop = new ArrayList<ItemsList>();
		SQLiteDatabase db = this.getWritableDatabase();
		// Select All Query
		String sSQL = "SELECT * FROM  phrase " ;
		Cursor cursor = db.rawQuery(sSQL, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ItemsList lop = new ItemsList();
				lop.setVietnamese(cursor.getString(8));
				lop.setJapanese(cursor.getString(4));
				lop.setPinyin(cursor.getString(3));

				// Adding Lop to list
				listLop.add(lop);
				Log.d("=============>", "" + listLop);
			} while (cursor.moveToNext());
		}
		return listLop;
	}
	public ArrayList<ItemsList> getAll(int a) {
		ArrayList<ItemsList> listLop = new ArrayList<ItemsList>();
		SQLiteDatabase db = this.getWritableDatabase();
		// Select All Query
		String sSQL = "SELECT * FROM  phrase where category_id =" +a;
		Cursor cursor = db.rawQuery(sSQL, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ItemsList lop = new ItemsList();
				lop.setVietnamese(cursor.getString(8));
				lop.setJapanese(cursor.getString(4));
				lop.setPinyin(cursor.getString(3));

				// Adding Lop to list
				listLop.add(lop);
				Log.d("=============>", "" + listLop);
			} while (cursor.moveToNext());
		}
		return listLop;
	}
	public ArrayList<ItemsList> getVoice(int a) {
		ArrayList<ItemsList> listLop = new ArrayList<ItemsList>();
		// Select All Query
		String sSQL = "SELECT  * FROM phrase where category_id="+a;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sSQL, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ItemsList lop = new ItemsList();
				lop.setVoice(cursor.getString(6));
				// Adding Lop to list
				listLop.add(lop);
			} while (cursor.moveToNext());
		}

		// return contact list
		return listLop;
	}
//	public List<String> getAllUsers(){
//		List<String> listUsers = new ArrayList<String>();
//		SQLiteDatabase db = this.getWritableDatabase();
//		Cursor c;
//		
//		try {
//			c = db.rawQuery("SELECT * FROM " + TB_USER , null);
//			if(c == null) return null;
//			
//			String name;
//			c.moveToFirst();
//			do {			
//				name = c.getString(1);			
//				listUsers.add(name);
//			} while (c.moveToNext()); 
//			c.close();
//		} catch (Exception e) {
//			Log.e("tle99", e.getMessage());
//		}
//		
//	
//	
//		db.close();		
//		
//		return listUsers;
//	}
//	
//		
	/***
	 * Open database
	 * @throws SQLException
	 */
	public void openDataBase() throws SQLException{
		String myPath = DB_PATH + DB_NAME;
		myDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
	}

	/***
	 * Copy database from source code assets to device
	 * @throws IOException
	 */
	public void copyDataBase() throws IOException{
		try {
			InputStream myInput = context.getAssets().open(DB_NAME);
			String outputFileName = DB_PATH + DB_NAME;
			OutputStream myOutput = new FileOutputStream(outputFileName);

			byte[] buffer = new byte[1024];
			int length;

			while((length = myInput.read(buffer))>0){
				myOutput.write(buffer, 0, length);
			}

			myOutput.flush();
			myOutput.close();
			myInput.close();
		} catch (Exception e) {
			Log.e("tle99 - copyDatabase", e.getMessage());
		}
		
	}
	
	/***
	 * Check if the database doesn't exist on device, create new one
	 * @throws IOException
	 */
	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();		
		
		if (dbExist) {

		} else {
			this.getReadableDatabase();
			try {
				copyDataBase();
			} catch (IOException e) {
				Log.e("tle99 - create", e.getMessage());
			}
		}
	}
	
	// ---------------------------------------------
	// PRIVATE METHODS
	// ---------------------------------------------
	
	/***
	 * Check if the database is exist on device or not
	 * @return
	 */
	private boolean checkDataBase() {
		SQLiteDatabase tempDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			tempDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
		} catch (SQLiteException e) {
			Log.e("tle99 - check", e.getMessage());
		}
		if (tempDB != null)
			tempDB.close();
		return tempDB != null ? true : false;
	}
	

}
